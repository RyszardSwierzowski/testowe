import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        Button buttonWyborLogowanie = new Button("Logowanie");
        Button buttonWyborRejestracja = new Button("Rejestracja");
        buttonWyborLogowanie.setOnAction(e->window.setScene(logowanieWidok));
        buttonWyborRejestracja.setOnAction(e->window.setScene(rejestracjaWidok));

            VBox vboxWybor = new VBox(20);
            HBox hboxWybor = new HBox(10);
            hboxWybor.getChildren().setAll(buttonWyborLogowanie,buttonWyborRejestracja);
            vboxWybor.setPadding(new Insets(50,10,10,50));

        vboxWybor.getChildren().setAll(label1,hboxWybor);
        wyborWidok = new Scene(vboxWybor,500,300);

        /*
                WYBRANO OPCJE LOGOWANIA
         */
        Button buttonZaloguj = new Button("Zaloguj");
        Button buttonWroc = new Button("Powrot");
        buttonZaloguj.setOnAction(e->window.setScene(zalogowanoWidok));
        buttonWroc.setOnAction(e->window.setScene(wyborWidok));

        VBox vboxLogowanie = new VBox(20);
        TextField loginLogowanie = new TextField();
        loginLogowanie.setPromptText("Login");
        PasswordField passwordLogowanie = new PasswordField();
        passwordLogowanie.setPromptText("Haslo");


        vboxLogowanie.getChildren().setAll(loginLogowanie,passwordLogowanie,buttonZaloguj,buttonWroc);
        logowanieWidok = new Scene(vboxLogowanie,500,500);

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
        window.setScene(wyborWidok);
        window.show();
        window.setResizable(false);


    }


    public static void main(String[] args) {

        launch(args);

    }
}