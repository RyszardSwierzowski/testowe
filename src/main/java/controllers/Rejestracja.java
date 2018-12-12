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
        try{ //TODO: poprawic to bo wyglada marnie
            if(validate.compareRegisterPasswd(hasloField.getText(), powtorzhasloField.getText())){
                if (validate.validateTextField(imieField.getText())){ //imie
                    if(validate.validateTextField(nazwiskoField.getText())){ //nazwisko
                        if(validate.validateTextField(loginField.getText())){ //login
                            if(validate.validateNumberField(telefonField.getText())){//telefon
                                if(validate.validateEmail(emailField.getText())){//email

                                    System.out.println("UDALO SIE PREJSC WERIFIKACJE JEEEEJ");
                                    //todo: stworzyc obiekt uzytkownika w sumie xD
                                    //TODO: w przyszłości dodac tutaj jakies polacznie z baza danych i wyslac polecenie dodania uzytkownika
                                    //todo: aha no i jak kliknie to tam przeneiesc do jakiegos nwm strony logowania albo wyswietlic glowna strone aplikacji
                                }
                            }
                        }
                    }
                }
            }

        }catch (Exception ex){
            System.out.println("BUUUU");
        }

    }



}
