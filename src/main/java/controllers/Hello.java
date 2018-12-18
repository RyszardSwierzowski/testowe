package controllers;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class Hello {


    @FXML
    private Button zalogunButton;

    @FXML
    private Button registerButton;

    @FXML
    void loginClick() throws Exception{
        System.out.println("Login button");

        Parent root = FXMLLoader.load(getClass().getResource("viewsFxml/logowanie.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Logowanie");
        stage.setScene(new Scene(root, 100, 200));
        stage.show();

    }

    @FXML
    void registerClick() {
        System.out.println("register button");
    }

}
