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



public class Main extends Application {


    Stage window;
    Scene wyborWidok, logowanieWidok, rejestracjaWidok, zalogowanoWidok;


    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;



        /*
                DECYZJA LOGOWANIE CZY REJESTRACJA
         */
        Label label1 = new Label("Wybierz opcje logowania");
        Label labelPrzywitanie = new Label("Witaj w naszym klubie dla aktywnych :)");
        Button buttonWyborLogowanie = new Button("Logowanie");
        Button buttonWyborRejestracja = new Button("Rejestracja");
        buttonWyborLogowanie.setOnAction(e->window.setScene(logowanieWidok));
        buttonWyborRejestracja.setOnAction(e->window.setScene(rejestracjaWidok));

            labelPrzywitanie.setFont(new Font("Arial",25));
            labelPrzywitanie.setTextAlignment(TextAlignment.CENTER);

             VBox vboxWybor = new VBox(30);
            HBox hboxWybor = new HBox(25);
                vboxWybor.setAlignment(Pos.CENTER);
                hboxWybor.setAlignment(Pos.CENTER);
            hboxWybor.getChildren().setAll(buttonWyborLogowanie,buttonWyborRejestracja);
            //vboxWybor.setPadding(new Insets(50,10,10,50));
            //hboxWybor.setPadding(new Insets(5,10,10,50));

        vboxWybor.getChildren().setAll(labelPrzywitanie,label1,hboxWybor);
        wyborWidok = new Scene(vboxWybor,550,300);

        /*
                WYBRANO OPCJE LOGOWANIA
         */
        Button buttonZaloguj = new Button("Zaloguj się");
        Button buttonWroc = new Button("Powrót");
        buttonZaloguj.setOnAction(e->window.setScene(zalogowanoWidok));
        buttonWroc.setOnAction(e->window.setScene(wyborWidok));
        Label labelLogowanie = new Label("Podaj swoje dane do logowania");

        VBox vboxLogowanie = new VBox(20);
        HBox hboxLogowanie = new HBox(25);
        TextField loginLogowanie = new TextField();
        loginLogowanie.setPromptText("Login");
        PasswordField passwordLogowanie = new PasswordField();

            passwordLogowanie.setPromptText("Haslo");
            vboxLogowanie.setPadding(new Insets(75,50,75,50));
            hboxLogowanie.getChildren().setAll(buttonZaloguj,buttonWroc);
            labelLogowanie.setFont(new Font("Arial",25));


        vboxLogowanie.getChildren().setAll(labelLogowanie,loginLogowanie,passwordLogowanie,hboxLogowanie);
        logowanieWidok = new Scene(vboxLogowanie,500,300);

        /*
                WYBOR OPCJI REJESTRACJI
          */
        VBox vboxRejsetracja = new VBox(20);
        TextField imieRejestracja = new TextField();
        TextField nazwiskorejestracja = new TextField();
        TextField adresEmailRejestracja = new TextField();
        TextField telefonRejestracja = new TextField();
        TextField loginRejestracja = new TextField();
        PasswordField passwordRejestracja = new PasswordField();
        PasswordField repetPasswordRejestracja = new PasswordField();
        Button buttonZarejestrujRejestracja = new Button("Zarejestruj się");
        Button buttonWrocRejestracja = new Button("Powrót");

        imieRejestracja.setPromptText("Imie");
        nazwiskorejestracja.setPromptText("Nazwisko");
        adresEmailRejestracja.setPromptText("Adres e-mail");
        telefonRejestracja.setPromptText("Numer kontaktowy");
        loginRejestracja.setPromptText("Login");
        passwordRejestracja.setPromptText("Hasło");
        repetPasswordRejestracja.setPromptText("Powtórz hasło");

        buttonWrocRejestracja.setOnAction(e->window.setScene(wyborWidok));

        vboxRejsetracja.getChildren().setAll(
                imieRejestracja,
                nazwiskorejestracja,
                adresEmailRejestracja,
                telefonRejestracja,
                loginRejestracja,
                passwordRejestracja,
                repetPasswordRejestracja,
                buttonZarejestrujRejestracja,
                buttonWrocRejestracja
        );
        rejestracjaWidok = new Scene(vboxRejsetracja,500,500);

        /*
                    POPRAWNE LOGOWANIE / REJESTRACJA
          */
        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/mainView.fxml"));
        zalogowanoWidok = new Scene(root, 1200, 700);

        /*
            STARTOWA SCENA
         */
        window.setScene(rejestracjaWidok);
        window.show();
        window.setResizable(false);


    }


    public static void main(String[] args) {

        launch(args);

    }
}