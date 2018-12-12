import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public Main main;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/rejestracja.fxml"));
        primaryStage.setTitle("Twój Trening");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        main = this;



    }


    public static void main(String[] args) {
        launch(args);
    }
}