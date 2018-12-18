package utilities;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowInitial extends Application {

    int width,height;
    String title, fxml;

    public WindowInitial(int width, int height, String title, String fxml){
        this.width = width;
        this.height = height;
        this.title = title;
        this.fxml = fxml;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        System.out.println("INICJACJA " + title + " START");
    }


}
