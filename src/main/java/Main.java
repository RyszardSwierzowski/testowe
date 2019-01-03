import controllers.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


import jdbcDriver.Driver;
import utilities.ValidateUtilities;

import java.sql.SQLException;


public class Main extends Application {


    Stage window;
    Scene wyborWidok, logowanieWidok, rejestracjaWidok, zalogowanoWidok;


    static long currentUserID;


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
        //vboxWybor.setPadding(new Insets(50,10,10,50));
        //hboxWybor.setPadding(new Insets(5,10,10,50));

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
        TextField loginLogowanie = new TextField();
        loginLogowanie.setPromptText("Login");
        PasswordField passwordLogowanie = new PasswordField();

        passwordLogowanie.setPromptText("Haslo");
        vboxLogowanie.setPadding(new Insets(75, 50, 75, 50));
        hboxLogowanie.getChildren().setAll(buttonZaloguj, buttonWroc);
        labelLogowanie.setFont(new Font("Arial", 25));

        vboxLogowanie.getChildren().setAll(labelLogowanie, loginLogowanie, passwordLogowanie, hboxLogowanie);
        logowanieWidok = new Scene(vboxLogowanie, 500, 300);

        buttonZaloguj.setOnAction(e ->
        {

            {

            }
            try {
                if (Driver.tryToLogIn(loginLogowanie.getText(), passwordLogowanie.getText()) == true) {
                    System.out.println("Logowanie ok");
                    //currentUserID=Driver.getCurrentId(loginLogowanie.getText());
                    //MainView.setView();
                    window.setScene(zalogowanoWidok);
                } else {
                    System.out.println("Blad");
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
        TextField nazwiskorejestracja = new TextField();
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
            //todo walidacja pól i czy są uzupełnione
            if (0==0
//                    imieRejestracja.getText().length() > 3 &&
//                            ValidateUtilities.isItFromLettersOnly(imieRejestracja.getText()) &&
//                    nazwiskorejestracja.getText().length() > 3 &&
//                            ValidateUtilities.isItFromLettersOnly(nazwiskorejestracja.getText()) &&
//                    adresEmailRejestracja.getText().length() > 0 &&
//                            ValidateUtilities.validateEmail(adresEmailRejestracja.getText())==true &&
//                    telefonRejestracja.getText().length() > 0 &&
//                            ValidateUtilities.validateNumberField(telefonRejestracja.getText())==true &&
//                    loginRejestracja.getText().length() > 0 &&
//                            ValidateUtilities.isItFromLettersOnly(loginRejestracja.getText()) &&
//                    passwordRejestracja.getText().length() > 0 &&
//                    repetPasswordRejestracja.getText().length() > 0 &&
//                    passwordRejestracja.getText().equals(repetPasswordRejestracja.getText())
                    ) {

                try {
                    if (Driver.tryToAddANewUser(loginRejestracja.getText(), adresEmailRejestracja.getText()) == true) {
                        System.out.println("Rejestracjaok ok");
                        Driver.addNewUserToDataBase(imieRejestracja.getText(),nazwiskorejestracja.getText(),loginRejestracja.getText(),passwordRejestracja.getText(),telefonRejestracja.getText(),adresEmailRejestracja.getText());
                        window.setScene(zalogowanoWidok);
                    } else {
                        System.out.println("Blad");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });

        imieRejestracja.setPromptText("Imie");
        nazwiskorejestracja.setPromptText("Nazwisko");
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
                nazwiskorejestracja,
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
        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/mainView.fxml"));
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