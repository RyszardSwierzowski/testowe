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


public class MainView  {

    public boolean isLoged = false;

    @FXML
    private Button userButtonOkresZawieszeniaKonta;
    @FXML
    private Label platnoscKarta;
    @FXML
    private Button userUsunKonto;

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
    private ComboBox<String> userWybierzOkresZawieszeniaKonta;
    @FXML
    private Label userTelefon;
    @FXML
    private Label userStatus;

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

    @FXML
    private TableView<DostępneTreningiTabele> tableDostepne2;
    @FXML
    private TableColumn<DostępneTreningiTabele, Integer> Lp2;
    @FXML
    private TableColumn<DostępneTreningiTabele, String> Nazwa2;
    @FXML
    private TableColumn<DostępneTreningiTabele, String> Termin2;
    @FXML
    private TableColumn<DostępneTreningiTabele, String> Trener2;
    @FXML
    private TableColumn<DostępneTreningiTabele, Integer> Czas2;
//    @FXML
//    private TableColumn<DostępneTreningiTabele, Integer> Limit;


    Klient klient;

    public MainView() throws SQLException {
    }

//  URZYTKOWNICY
    public void setView() throws SQLException {
        klient = Driver.getInfoAboutUser();
        userImie.setText("Imię : " + klient.getImie());
        userNazwisko.setText("Nazwisko : " + klient.getNazwisko());
        userLogin.setText("Login : " + klient.getLogin());
        userEmail.setText("Email : " + klient.getAdresEmail());
        userTelefon.setText("Numer kontaktowy : " + String.valueOf(klient.getNumerKontaktowy()));
        userLogin.setText("Login : " + klient.getLogin());
        userStatus.setText(Driver.getStatus());
        setComboBoxyDlaKonta();

    }
    public void zmienDaneUzytkownika() throws SQLException {

        // POBIERZ DANE Z FORMULARZA
        String noweImie = userEdycjaNoweImie.getText().trim();
        String noweNazwisko = userEdycjaNoweNazwisko.getText().trim();
        String nowyEmail = userEdycjaNoweAdresEmail.getText().trim();
        String nowyNumerKontaktowy = userEdycjaNowyNumerKontaktowy.getText().trim();

        Driver.editUser(noweImie,noweNazwisko,nowyNumerKontaktowy,nowyEmail);
    }
    public void setComboBoxyDlaKonta(){
        ObservableList<String> zawieszanieKonta = FXCollections.observableArrayList(Arrays.asList("Zawieś na 1 miesiąc","Zawieś na 2 miesiące","Zawieś na 3 miesiące","Zawieś na 6 miesiący","Zawieś na 1 rok"));
        //ObservableList<String> zawieszanieKonta = FXCollections.observableArrayList(new String("dsada"));
        userWybierzOkresZawieszeniaKonta.setItems(zawieszanieKonta);

    }

// TABLICA MOICH TRENINGOW
    public void setTableMojeTreningi() throws SQLException {
        ObservableList<DostępneTreningiTabele> listaMoichTreningow = FXCollections.observableArrayList(
                DostępneTreningiTabele.generujMojeTreningi(Driver.getMojeZapisy(Driver.getCurrentID()), Driver.getCurrentID()));
        Lp.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, Integer>("Lp"));
        Nazwa.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Nazwa"));
        Termin.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Termin"));
        Trener.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Trener"));
        Czas.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, Integer>("Czas"));

        tableDostepne.setItems(listaMoichTreningow);
    }

// TABLICA DOSTEPNYCH TRENINGOW
    public void setTableDostepneTreningi() throws SQLException {
        ObservableList<DostępneTreningiTabele> listaDostepnychTreningow = FXCollections.observableArrayList(DostępneTreningiTabele.generujWszystkieTreningi() );
        Lp2.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, Integer>("Lp"));
        Nazwa2.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Nazwa"));
        Termin2.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Termin"));
        Trener2.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, String>("Trener"));
        Czas2.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, Integer>("Czas"));
       // Limit.setCellValueFactory(new PropertyValueFactory<DostępneTreningiTabele, Integer>("Limit"));


        tableDostepne2.setItems(listaDostepnychTreningow);
    }




}

















