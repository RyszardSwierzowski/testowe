package controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import jdbcDriver.Driver;
import user.Klient;

import java.sql.SQLException;
import java.util.HashMap;
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

    //    @FXML public void initialize() throws SQLException {
//        //userImie.setText(Driver.getInfoAboutUser().getImie());
//        System.out.println("SSSSSSSSSSSSSSSS");
//    }
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


}

















