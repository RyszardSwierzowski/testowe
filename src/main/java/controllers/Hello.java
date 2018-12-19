package controllers;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class Hello {


    @FXML
    private Button zalogunButton;

    @FXML
    private Button registerButton;
    Stage primaryStage;
    @FXML
    void loginClick() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/hello.fxml"));
        primaryStage.setTitle("Twój Trening");
        primaryStage.setScene(new Scene(root, 468, 155));
        primaryStage.show();



    }

    @FXML
    void registerClick() {
        System.out.println("register button");
    }


}
