package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Logowanie {

    @FXML private Button buttonZaloguj;
    @FXML private PasswordField passwordField;
    @FXML private TextField loginField;

    String loginFromField;
    String passwordFromField;

    @FXML void initialize(){

    }

    @FXML public void onActionButtonZaloguj(){
        getTextFromLoginAndPasswordFields();
    }
    private void getTextFromLoginAndPasswordFields(){
        loginFromField = loginField.getText();
        passwordFromField = passwordField.getText();

        if( validateLogin(loginFromField) == false )
        {
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nieudane controllers.Logowanie");
            alert.setHeaderText(null);
            alert.setContentText("Login może zawierać tylko litery i cyfry !!!");

            alert.showAndWait();

        }
        else
            System.out.println("login ok ");
//        System.out.println("login " +loginFromField);
//        System.out.println("passw " +passwordFromField);

    }

    public static boolean validateLogin(String login){// login może zawierać tylko duże i małe litery oraz cyfry arabskie. W przeciwnym wypadku -> return false
        char[] loginArray=login.toCharArray();
        for (char x:loginArray)
        {
            if( !( (x<=95&&x>=65) || (x<=122&&x>=97) || (x<=57&&x>=48) ) )
                return false;
        }
        return  true;

    }
}
