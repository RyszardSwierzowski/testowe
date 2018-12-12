package utilities;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ValidateUtilities {

    public ValidateUtilities() {
    }

    public boolean compareRegisterPasswd(PasswordField first, PasswordField repeat){
    if(first.equals(repeat)) return true;
    else return false;
    }


}
