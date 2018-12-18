import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import utilities.WindowInitial;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/hello.fxml"));
        primaryStage.setTitle("Twój Trening");
        primaryStage.setScene(new Scene(root, 468, 155));
        primaryStage.show();
        System.out.println("INICJACJA START");
    }


    public static void main(String[] args) {

        launch(args);

    }
}