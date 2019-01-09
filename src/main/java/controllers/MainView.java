package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import jdbcDriver.Driver;
import treningi.DostępneTreningiTabele;
import user.Klient;
import utilities.ValidateUtilities;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;


public class MainView implements Initializable {

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

    @FXML
    private TableView<DostępneTreningiTabele> tableDostepne;
    @FXML
    private TableColumn<DostępneTreningiTabele, Integer> Lp;
    @FXML
    private TableColumn<DostępneTreningiTabele, String> Nazwa;
    @FXML
    private TableColumn<DostępneTreningiTabele, String> Termin;
    @FXML
    private TableColumn<DostępneTreningiTabele, String> Trener;
    @FXML
    private TableColumn<DostępneTreningiTabele, Integer> Czas;


    Klient klient;

    public MainView() throws SQLException {
    }

    // todo zrobic na klasie klient


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

    public void zmienDaneUzytkownika() {
        Map<String, String> noweDane = new HashMap<>();
        List<String> listaBledow = new ArrayList<>();
        // POBIERZ DANE Z FORMULARZA
        String noweImie = userEdycjaNoweImie.getText().trim();
        String noweNazwisko = userEdycjaNoweNazwisko.getText().trim();
        String nowyEmail = userEdycjaNoweAdresEmail.getText().trim();
        String nowyNumerKontaktowy = userEdycjaNowyNumerKontaktowy.getText().trim();
        // DODAJ DO MAPY JEŚLI WPROWADZONE
        if (noweImie.length() > 0) {
            if (ValidateUtilities.isText(noweImie) == true)
                noweDane.put("imie", noweImie);
            else
                listaBledow.add("Niepoprawne nowe imię");
        }

        if (noweNazwisko.length() > 0) {
            if (ValidateUtilities.isText(noweNazwisko) == true)
                noweDane.put("nazwisko", noweNazwisko);
            else
                listaBledow.add("Niepoprawne nowe nazwisko");
        }

        if (nowyEmail.length() > 0) {
            if (ValidateUtilities.validateEmail(nowyEmail) == true)
                noweDane.put("email", nowyEmail);
            else
                listaBledow.add("Niepoprawne nowy email");
        }
        if (nowyNumerKontaktowy.length() > 0) {
            if (ValidateUtilities.isMobilePhoneNumber(nowyNumerKontaktowy) == true)
                noweDane.put("tel", nowyNumerKontaktowy);
            else
                listaBledow.add("Niepoprawne nowy numer");
        }


        listaBledow.stream().forEach(x -> System.out.println(x));


    }

    // TABLICA DOSTĘPNYCH TRENINGOW
    public ObservableList<DostępneTreningiTabele> list = FXCollections.observableArrayList(
            DostępneTreningiTabele.generujMojeTreningi(Driver.getMojeZapisy(4),4)
//            new DostępneTreningiTabele(1, "sd", "dsa", "dsa", 32),
//            new DostępneTreningiTabele(2, "sd", "dsa", "dsa", 45)
    );



    public void setTableMojeTreningi(){
        Lp.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, Integer>("Lp"));
        Nazwa.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Nazwa"));
        Termin.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Termin"));
        Trener.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Trener"));
        Czas.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, Integer>("Czas"));

        tableDostepne.setItems(list);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }
}

















