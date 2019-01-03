package controllers.doSkasowaniaChyba;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TestowyWidok   {

    @FXML
    private Button button;
    Stage primaryStage;
    @FXML
    void press() throws Exception {
        System.out.println("XXX");
        start();
    }


    public void start() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/testowyWidok.fxml"));
        primaryStage.setTitle("Twój Trening");
        primaryStage.setScene(new Scene(root, 468, 155));
        primaryStage.show();
    }
}