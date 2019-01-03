package utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ValidateUtilities {

    Alert alert = new Alert(Alert.AlertType.WARNING);

    public ValidateUtilities() {
    }

    public boolean compareRegisterPasswd(String first, String repeat){
        System.out.println("walidacja");

        alert.setTitle("Błąd rejestracji");
        alert.setHeaderText(null);

        if(!(first.equals("") || repeat.equals(""))){ //sprawdzam czy hasla nie sa puste
            System.out.println("validate not null");

            if(!first.contains(" ")){ //sprawdzenie czy zawiera znaki ktoych nie chcemy

                if(first.equals(repeat)){ //sprawdzenie czy sa takie same
                    return true;
                }
                else{
                    return false;
                }

            }else{
                alert.setContentText("podane hasło zawiera niedozwolone znaki");
                alert.showAndWait();  //--
                return false;
            }


        }else{

            alert.setContentText("podane hasło jest puste");
            alert.showAndWait();
            return false;
        }
    }

    public static boolean validateEmail(String email){
    boolean result = true;

    if(!email.contains("@")) result = false; //prosta walidacja czy nie zawira @
    return result;
    }

    public static boolean isItFromLettersOnly(String string){
        boolean result = true;

        if(string.contains(" ")) result = false;
        char[] Array=string.toCharArray();
        for (char x:Array)
        {
            if( !( (x<=95&&x>=65) || (x<=122&&x>=97) ) )
                result = false;
        }
        return result;
    }

    public boolean validateTextField(String string){ //funkcja walidujaca zwykly ciag znakowy czy zawiera niedozwolone znaki
        boolean result = true;

        if(string.contains(" ")) result = false;
        char[] Array=string.toCharArray();
        for (char x:Array)
        {
            if( !( (x<=95&&x>=65) || (x<=122&&x>=97) || (x<=57&&x>=48) ) )
                result = false;
        }
        return result;
    }

    public static boolean validateNumberField(String str){
        boolean result = true;

        if(str.contains(" ")) result = false;
        char[] Array = str.toCharArray();
        for(char x:Array){
            if(!(x>=48 && x<=57))
                result = false;
        } //48 - > 57 ascii dla liczb

        return result;
    }



}
