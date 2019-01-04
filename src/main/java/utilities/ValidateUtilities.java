package utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ValidateUtilities {


    public static boolean validateNewLogin(String login) {
        char[] tab = login.toCharArray();

        // DŁUGOŚĆ LOGINU POWYŻEJ 5 ZNAKÓW
        if (login.length() < 5){
            System.out.println("login");
            return false;
        }


        // ZAWIERA TYLKO CYFRY I LITERY
        for (int i = 0; i < tab.length; i++) {
            if (!(tab[i] >= 48 && tab[i] <= 57) && !(tab[i] >= 65 && tab[i] <= 90) && !(tab[i] >= 97 && tab[i] <= 122)) {
                System.out.println("login");
                return false;
            }
        }
        return true;
    }
    public static boolean validateNewPassword(String password) {
        char[] tab = password.toCharArray();
        boolean isDuzaLitera = false;
        boolean isMalaLitera = false;
        boolean isNumber = false;
        boolean isSpecialChar = false;

        // DŁUGOŚĆ HASŁA POWYŻEJ 8 ZNAKÓW
        if (password.length() < 5){
            System.out.println("haslo");
            return false;
        }

        // ZAWIERA CONAJMNIEJ JEDNĄ CYFRE , LITERE , ZNAK SPECJALNY
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] >= 48 && tab[i] <= 57){
                System.out.println("cyfra");
                isNumber = true;}
            else if (tab[i] >= 65 && tab[i] <= 90){
                System.out.println("L");
                isDuzaLitera = true;
            }
            else if (tab[i] >= 97 && tab[i] <= 122){
                System.out.println("l");
                isMalaLitera = true;
            }else{
                System.out.println("spec");
                isSpecialChar = true;
            }


        }
        if (isDuzaLitera == true && isDuzaLitera == true && isNumber == true && isSpecialChar == true && isMalaLitera == true)
            return true;

            System.out.println("pass");
            return false;

    }
    public static boolean isText(String str) {
        char[] tab = str.toCharArray();

        for (int i = 0; i < tab.length; i++) {
            if(tab[i]<65 || tab[i]>122 || (tab[i]>90 && tab[i]<65)){
                System.out.println("tekst");
                return false;
            }
           //

        }
        return true;
    }
    public static boolean isNumber(String str) {
        char[] tab = str.toCharArray();

        for (int i = 0; i < tab.length; i++) {
            if (!(tab[i] >= 48 && tab[i] <= 57) ){
                System.out.println("cyfra");
                return false;
            }
        }
        return true;
    }
    public static boolean validateEmail(String email){
        String[] tab1, tab2;
        int ileMalp=0;
        int malpaPozycja=0;
        int ostaniaKropka=-1;

        // todo walidacja email

        tab1=email.split("@");
        tab2=email.split(".");

//        if(tab1[tab1.length-1].equals("@") || tab2[tab2.length-1].equals(".") || tab2[0].equals("."))
//            return false;
//
//        for(int i=1;i<tab1.length;i++){
//            if(tab1[i].equals("@"))
//                ileMalp++;
//            malpaPozycja=i;
//        }
//
//        if(ileMalp!=1)
//            return false;
//
//        for(int i=malpaPozycja;i<tab2.length;i++){
//            if(tab2[i].equals("."))
//                ostaniaKropka=i;
//        }
//
//        if(ostaniaKropka<malpaPozycja)
//            return false;


        return true;
    }
    public static boolean isMobilePhoneNumber(String phoneNumber){
        if(!isNumber(phoneNumber) || phoneNumber.length()!=9){
            System.out.println("tel");
            return false;
        }
        return true;
    }




}
