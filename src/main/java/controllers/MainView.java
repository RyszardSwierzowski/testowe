package controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import jdbcDriver.Driver;
import user.Klient;
import utilities.ValidateUtilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainView {

    public boolean isLoged = false;

    @FXML
    private Button userButtonOkresZawieszeniaKonta;
    @FXML
    private Label platnoscKarta;
    @FXML
    private Button userUsunKonto;
    @FXML
    private Label userStatus;
    @FXML
    private Button platnoscZmienNrKarty;
    @FXML
    private Label userNazwisko;
    @FXML
    private TextField userEdycjaNoweNazwisko;
    @FXML
    private Label platnoscStatus;
    @FXML
    private Label userLogin;
    @FXML
    private TextField userEdycjaNowyNumerKontaktowy;
    @FXML
    private Label userImie;
    @FXML
    private Button userEdycjaButtonZmienDane;
    @FXML
    private Label platnoscTerminPlatnosci;
    @FXML
    private Label userEmail;
    @FXML
    private TextField userEdycjaNoweAdresEmail;
    @FXML
    private Button userButtonRezygnacjaZCzlonkostwa;
    @FXML
    private TextField userEdycjaNoweImie;
    @FXML
    private ComboBox<?> userWybierzOkresZawieszeniaKonta;
    @FXML
    private Label userTelefon;


    Klient klient;

    // todo zrobic na klasie klient

        @FXML public void initialize() throws SQLException {
            Driver.getImfoAboutAvailableTrainings();

    }
//    public static  void setView() throws SQLException {
//        userImie.setText(Driver.getInfoAboutUser().getImie());
//    }
    public void setView() throws SQLException {
        klient = Driver.getInfoAboutUser();
        userImie.setText("Imię : " + klient.getImie());
        userNazwisko.setText("Nazwisko : " + klient.getNazwisko());
        userLogin.setText("Login : " + klient.getLogin());
        userEmail.setText("Email : " + klient.getAdresEmail());
        userTelefon.setText("Numer kontaktowy : " + String.valueOf(klient.getNumerKontaktowy()));
        userLogin.setText("Login : " + klient.getLogin());

        userStatus.setTextFill(Color.GRAY);
        //System.out.println(klient.getLogin());

        //System.out.println("|"+klient.getImie()+"|");
    }
    public void zmienDaneUzytkownika(){
            Map<String,String> noweDane = new HashMap<>();
            List<String> listaBledow= new ArrayList<>();
        // POBIERZ DANE Z FORMULARZA
            String noweImie= userEdycjaNoweImie.getText().trim();
            String noweNazwisko= userEdycjaNoweNazwisko.getText().trim();
            String nowyEmail= userEdycjaNoweAdresEmail.getText().trim();
            String nowyNumerKontaktowy= userEdycjaNowyNumerKontaktowy.getText().trim();
        // DODAJ DO MAPY JEŚLI WPROWADZONE
            if(noweImie.length()>0) {
                if (ValidateUtilities.isText(noweImie) == true)
                    noweDane.put("imie", noweImie);
                else
                    listaBledow.add("Niepoprawne nowe imię");
            }

            if(noweNazwisko.length()>0) {
                if (ValidateUtilities.isText(noweNazwisko)==true)
                    noweDane.put("nazwisko", noweNazwisko);
                else
                    listaBledow.add("Niepoprawne nowe nazwisko");
            }

            if(nowyEmail.length()>0) {
                if (ValidateUtilities.validateEmail(nowyEmail) == true)
                    noweDane.put("email", nowyEmail);
                else
                    listaBledow.add("Niepoprawne nowy email");
            }
            if(nowyNumerKontaktowy.length()>0) {
                if (ValidateUtilities.isMobilePhoneNumber(nowyNumerKontaktowy) == true)
                    noweDane.put("tel", nowyNumerKontaktowy);
                else
                    listaBledow.add("Niepoprawne nowy numer");
            }


        listaBledow.stream().forEach(x->System.out.println(x));





    }


}

















