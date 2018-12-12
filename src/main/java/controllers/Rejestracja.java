package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utilities.ValidateUtilities;


public class Rejestracja {

    @FXML
    private PasswordField powtorzhasloField;

    @FXML
    private Button zarejestrujButton;

    @FXML
    private TextField nazwiskoField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField hasloField;

    @FXML
    private TextField telefonField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField imieField;

    /* ----------- */
    ValidateUtilities validate = new ValidateUtilities();


    @FXML
    public void onActionZarejestrujButton(){
        System.out.println("klikniecie");
        try{
            if(validate.compareRegisterPasswd(hasloField, powtorzhasloField)){
                System.out.println("hasło takie same");

            }

        }catch (Exception ex){

        }

    }



}
