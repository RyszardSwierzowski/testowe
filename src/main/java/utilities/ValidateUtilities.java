package utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ValidateUtilities {

    Alert alert = new Alert(Alert.AlertType.WARNING);

    public ValidateUtilities() {
    }

    public boolean compareRegisterPasswd(PasswordField first, PasswordField repeat){
        if(!(first.equals(null) || repeat.equals(null))){
            if(first.equals(repeat)) return true;
            else return false;
        }else{
            return false;
        }
    }

    public boolean validateEmail(TextField email){

        return false;
    }

}
