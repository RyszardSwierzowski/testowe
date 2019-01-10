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
import user.StatusKonta;
import utilities.ValidateUtilities;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    @FXML
    private Tab kartaTwojeTreningi = new Tab();
    @FXML
    private  Tab kartaDostępneZajecia = new Tab();
//    @FXML
//    private TableColumn<DostępneTreningiTabele, Integer> Limit;

    public static StatusKonta statusKonta=StatusKonta.BRAK_DANYCH;
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
        Driver.getStatus();
        if(statusKonta!=StatusKonta.AKTYWNE)
        {
            kartaTwojeTreningi.setDisable(true);
            kartaDostępneZajecia.setDisable(true);
        }
        else{
            kartaTwojeTreningi.setDisable(false);
            kartaDostępneZajecia.setDisable(false);
        }
        userStatus.setText("     Status : "+statusKonta.toString());
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
        ObservableList<String> zawieszanieKonta = FXCollections.observableArrayList(Arrays.asList("1.  Zawieś na 1 miesiąc","2.  Zawieś na 2 miesiące","3.  Zawieś na 3 miesiące","4.  Zawieś na 6 miesiący","5.  Zawieś na 1 rok"));
        //ObservableList<String> zawieszanieKonta = FXCollections.observableArrayList(new String("dsada"));
        userWybierzOkresZawieszeniaKonta.setItems(zawieszanieKonta);

    }
    public void zawiesKonto() throws SQLException {
        if(userWybierzOkresZawieszeniaKonta.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Nie wybrano okresu zawieszenia");
            alert.showAndWait();
        }
        else{
            String termin="";
            LocalDate now = LocalDate.now();
            if(userWybierzOkresZawieszeniaKonta.getSelectionModel().getSelectedIndex()==0){
                now = LocalDate.now().plus(1, ChronoUnit.MONTHS);
            }else if (userWybierzOkresZawieszeniaKonta.getSelectionModel().getSelectedIndex()==1){
                now = LocalDate.now().plus(2, ChronoUnit.MONTHS);
            }else if(userWybierzOkresZawieszeniaKonta.getSelectionModel().getSelectedIndex()==2){
                now = LocalDate.now().plus(3, ChronoUnit.MONTHS);
            }else if(userWybierzOkresZawieszeniaKonta.getSelectionModel().getSelectedIndex()==3){
                now = LocalDate.now().plus(4, ChronoUnit.MONTHS);
            }else if(userWybierzOkresZawieszeniaKonta.getSelectionModel().getSelectedIndex()==4){
                now = LocalDate.now().plus(1, ChronoUnit.YEARS);
            }

            Driver.zmienStatusKonta(StatusKonta.ZAWIESZONE,now.toString());
        }
    }
    public void  usunKonto() throws SQLException {
        Driver.usunKonto();
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

















