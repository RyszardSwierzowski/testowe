import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import jdbcDriver.Driver;
import utilities.ValidateUtilities;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {


    Stage window;
    Scene wyborWidok, logowanieWidok, rejestracjaWidok, zalogowanoWidok;





    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        /*
                DECYZJA LOGOWANIE CZY REJESTRACJA
         */
        Label label1 = new Label("Wybierz opcje logowania");
        Label labelPrzywitanie = new Label("Witaj w naszym klubie dla aktywnych :)");
        Button buttonWyborLogowanie = new Button("Logowanie");
        Button buttonWyborRejestracja = new Button("Rejestracja");
        buttonWyborLogowanie.setOnAction(e -> window.setScene(logowanieWidok));
        buttonWyborRejestracja.setOnAction(e -> window.setScene(rejestracjaWidok));

        labelPrzywitanie.setFont(new Font("Arial", 25));
        labelPrzywitanie.setTextAlignment(TextAlignment.CENTER);

        VBox vboxWybor = new VBox(30);
        HBox hboxWybor = new HBox(25);
        vboxWybor.setAlignment(Pos.CENTER);
        hboxWybor.setAlignment(Pos.CENTER);
        hboxWybor.getChildren().setAll(buttonWyborLogowanie, buttonWyborRejestracja);


        vboxWybor.getChildren().setAll(labelPrzywitanie, label1, hboxWybor);
        wyborWidok = new Scene(vboxWybor, 550, 300);

        /*
                WYBRANO OPCJE LOGOWANIA
         */
        Button buttonZaloguj = new Button("Zaloguj się");
        Button buttonWroc = new Button("Powrót");

        buttonWroc.setOnAction(e -> window.setScene(wyborWidok));
        Label labelLogowanie = new Label("Podaj swoje dane do logowania");

        VBox vboxLogowanie = new VBox(20);
        HBox hboxLogowanie = new HBox(25);
        TextField loginLogowanie = new TextField("admin");
        loginLogowanie.setPromptText("Login");
        PasswordField passwordLogowanie = new PasswordField();
        passwordLogowanie.setText("admin");

        passwordLogowanie.setPromptText("Haslo");
        vboxLogowanie.setPadding(new Insets(75, 50, 75, 50));
        hboxLogowanie.getChildren().setAll(buttonZaloguj, buttonWroc);
        labelLogowanie.setFont(new Font("Arial", 25));

        vboxLogowanie.getChildren().setAll(labelLogowanie, loginLogowanie, passwordLogowanie, hboxLogowanie);
        logowanieWidok = new Scene(vboxLogowanie, 500, 300);

        buttonZaloguj.setOnAction(e ->
        {
            try {
                if (Driver.tryToLogIn(loginLogowanie.getText(), passwordLogowanie.getText()) == true) {
                    System.out.println("Logowanie ok");
                    //currentUserID=Driver.getCurrentId(loginLogowanie.getText());
                    //MainViewFinal.setView();
                    window.setScene(zalogowanoWidok);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Błąd logowania");
                    alert.setHeaderText(null);

                    System.out.println("Blad");
                    if (loginLogowanie.getText().length() < 1  || passwordLogowanie.getText().length()<1 )
                        alert.setContentText("Pola nie mogą być puste");
                    else {
                        alert.setContentText("Błędny login lub hasło");
                    }


                    alert.showAndWait();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });



        /*
                WYBOR OPCJI REJESTRACJI
          */
        VBox vboxRejsetracja = new VBox(20);
        HBox hboxRejestracja = new HBox(20);
        TextField imieRejestracja = new TextField();
        TextField nazwiskoRejestracja = new TextField();
        TextField adresEmailRejestracja = new TextField();
        TextField telefonRejestracja = new TextField();
        TextField loginRejestracja = new TextField();
        PasswordField passwordRejestracja = new PasswordField();
        PasswordField repetPasswordRejestracja = new PasswordField();
        Button buttonZarejestrujRejestracja = new Button("Zarejestruj się");
        Button buttonWrocRejestracja = new Button("Powrót");
        Label labelPodajDaneDorejestracji = new Label("Podaj swoje dane w celu utworzeneia konta");

        buttonWrocRejestracja.setOnAction(e -> window.setScene(wyborWidok));
        buttonZarejestrujRejestracja.setOnAction(e ->
        {
            List<String> listaBledowWFormularzuRejestracji= new ArrayList<>();
            String imie     = imieRejestracja.getText();
            String nazwisko = nazwiskoRejestracja.getText();
            String email    = adresEmailRejestracja.getText();
            String telefon  = telefonRejestracja.getText();
            String login    = loginRejestracja.getText();
            String haslo    = passwordRejestracja.getText();
            String haslo2   = repetPasswordRejestracja.getText();
            //todo walidacja pól i czy są uzupełnione
            boolean isCorrectImie=false;
            boolean isCorrectNazwisko=false;
            boolean isCorrectEmail=false;
            boolean isCorrectTelefon=false;
            boolean isCorrectLogin=false;
            boolean isCorrectPass=false;
            boolean isCorrectPass2=false;
        // IMIE
            if(imie.length()>2 && ValidateUtilities.isText(imie) ){
                isCorrectImie=true;
            }
            else {
                if(imie.length()<4)
                    listaBledowWFormularzuRejestracji.add("Imie powinno mieć więcej jak 3 znaki, a posiada : " + imie.length());
                if(ValidateUtilities.isText(imie)==false)
                    listaBledowWFormularzuRejestracji.add("Imie może się składać tylko ze znaków a-Z bez polskich znaków");
            }
        // NAZWISKO
            if(nazwisko.length()>2 && ValidateUtilities.isText(nazwisko) ){
                isCorrectNazwisko=true;
            }
            else {
                if(imie.length()<3)
                    listaBledowWFormularzuRejestracji.add("Imie powinno mieć więcej jak 2 znaki, a posiada : " + imie.length());
                if(ValidateUtilities.isText(nazwisko)==false)
                    listaBledowWFormularzuRejestracji.add("Nazwisko może się składać tylko ze znaków a-Z bez polskich znaków");
            }
        //EMAIL
            if(email.length()<=7){
                listaBledowWFormularzuRejestracji.add("email powinien posiadać min. 7 znaków");
            }else if(ValidateUtilities.validateEmail(login)==false){
                listaBledowWFormularzuRejestracji.add("Email zawiera niedowzowlne znaki - stosuj cyfry i litery");
            }else {
                isCorrectEmail=true;
            }
        //TELEFON
            if(telefon.length()!=9 || ValidateUtilities.isMobilePhoneNumber(telefon) == false ){
                listaBledowWFormularzuRejestracji.add("Telefon powinien zawierać dokładnie 9 cyfr");
            }
            else {
                isCorrectTelefon=true;
            }
        //LOGIN
            if(login.length()<=7 || ValidateUtilities.validateNewLogin(login) == false ){
                listaBledowWFormularzuRejestracji.add("Login powinien zawierać min. 7 oraz skałdadać się tylko z cyfr i liter");
            }else {
                isCorrectLogin=true;
            }
        // HASLA
            if(haslo.length()<=8 ){
                listaBledowWFormularzuRejestracji.add("Hasło powinno posiadać min. 8 znaków , jedną : znak specjalny małą i dużą literę");
            }else if(!haslo.equals(haslo2)){
                listaBledowWFormularzuRejestracji.add("Podane hasła się różnią od siebie ");
            }else {
                isCorrectPass=true;
            }

            if( listaBledowWFormularzuRejestracji.size()==0 ){
                    // JEŚLI WALIDACJA JEST OK
                try {
                    if (Driver.tryToAddANewUser(loginRejestracja.getText(), adresEmailRejestracja.getText()) == true) {
                        System.out.println("Rejestracjaok ok");
                        Driver.addNewUserToDataBase(imieRejestracja.getText(),nazwiskoRejestracja.getText(),loginRejestracja.getText(),passwordRejestracja.getText(),telefonRejestracja.getText(),adresEmailRejestracja.getText());
                        window.setScene(zalogowanoWidok);
                    } else {
                        System.out.println("Blad");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                }
                else
                {
                    // BŁĄD W WALIDACJI
                    String resultWarrning="";
                    for(String i:listaBledowWFormularzuRejestracji){
                        resultWarrning+=i+"\n";
                    }
                    System.out.println(resultWarrning);

                }




        });

        imieRejestracja.setPromptText("Imie");
        nazwiskoRejestracja.setPromptText("Nazwisko");
        adresEmailRejestracja.setPromptText("Adres e-mail");
        telefonRejestracja.setPromptText("Numer kontaktowy");
        loginRejestracja.setPromptText("Login");
        passwordRejestracja.setPromptText("Hasło");
        repetPasswordRejestracja.setPromptText("Powtórz hasło");

        labelPodajDaneDorejestracji.setFont(new Font("Arial", 24));
        labelPodajDaneDorejestracji.setTextAlignment(TextAlignment.CENTER);

        vboxRejsetracja.setPadding(new Insets(20, 25, 30, 25));

        hboxRejestracja.getChildren().addAll(buttonZarejestrujRejestracja, buttonWrocRejestracja);
        vboxRejsetracja.getChildren().setAll(
                labelPodajDaneDorejestracji,
                imieRejestracja,
                nazwiskoRejestracja,
                adresEmailRejestracja,
                telefonRejestracja,
                loginRejestracja,
                passwordRejestracja,
                repetPasswordRejestracja,
                hboxRejestracja
        );
        rejestracjaWidok = new Scene(vboxRejsetracja, 520, 450);

        /*
                    POPRAWNE LOGOWANIE / REJESTRACJA
          */
        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/mainViewFinal.fxml"));
        zalogowanoWidok = new Scene(root, 1200, 700);

        /*
            STARTOWA SCENA
         */
        window.setScene(wyborWidok);
        window.show();
        window.setResizable(false);


    }


    public static void main(String[] args) {

        launch(args);

    }

    private boolean sprawdzDaneLogowania(String login, String password) {
        return false;
    }

}