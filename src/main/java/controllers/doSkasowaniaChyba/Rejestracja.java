package controllers.doSkasowaniaChyba;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utilities.ValidateUtilities;


public class Rejestracja {

//    @FXML
//    private PasswordField powtorzhasloField;
//
//    @FXML
//    private Button zarejestrujButton;
//
//    @FXML
//    private TextField nazwiskoField;
//
//    @FXML
//    private TextField emailField;
//
//    @FXML
//    private PasswordField hasloField;
//
//    @FXML
//    private TextField telefonField;
//
//    @FXML
//    private TextField loginField;
//
//    @FXML
//    private TextField imieField;
//
//    /* ----------- */
//    ValidateUtilities validate = new ValidateUtilities();
//
//
//    @FXML
//    public void onActionZarejestrujButton(){
//        System.out.println("klikniecie");
//        boolean wynik = validateFIELDS();
//
//        if(wynik){
//        //todo dodac uzytkownika do bazy danych
//
//        //todo przeniesc do logowania
//
//        }
//    }
//
//    private boolean validateFIELDS() {
//
//        boolean request = false;
//
//        try{ //TODO: poprawic to bo wyglada marnie
//            if(validate.compareRegisterPasswd(hasloField.getText(), powtorzhasloField.getText())){
//                if (validate.validateTextField(imieField.getText())){ //imie
//                    if(validate.validateTextField(nazwiskoField.getText())){ //nazwisko
//                        if(validate.validateTextField(loginField.getText())){ //login
//                            if(validate.validateNumberField(telefonField.getText())){//telefon
//                                if(validate.validateEmail(emailField.getText())){//email
//                                     request = true;
//                                    System.out.println("UDALO SIE PREJSC WERIFIKACJE JEEEEJ");
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//        }catch (Exception ex){
//            System.out.println("BUUUU");
//        }
//        return request;
//    }


}
