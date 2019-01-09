package jdbcDriver;


import java.sql.*;
import java.util.*;

import javafx.scene.control.Alert;
import treningi.ListaTreningow;
import treningi.Terminarz;
import treningi.Trenerzy;
import treningi.Zapisy;
import user.Klient;
import utilities.ValidateUtilities;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Driver {


    private static int currentID = -1;

    public static int getCurrentID() {
        return currentID;
    }


    // LOGOWANIE REJESTRACJA
    public static boolean tryToLogIn(String log, String pass) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from logindata where password='" + pass + "' and login='" + log + "'");
            while (myRs.next()) {
                //System.out.println(myRs.getString("idUser"));
                currentID = Integer.parseInt(myRs.getString("idUser"));
                return true;
            }
            return false;
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        return false;
    }

    public static boolean tryToAddANewUser(String log, String email) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();


            //myRs = myStmt.executeQuery("select * from users where login='"+log+"' and email='"+email+"'   ");
            myRs = myStmt.executeQuery("select * from users where login='" + log + "'    ");
            while (myRs.next()) {
                //todo nie działa sprawdzanie czy login jest w bazie
                //System.out.println(myRs.getString("idUser"));
                return false;
            }
            return true;

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        return false;
    }

    public static void addNewUserToDataBase(String imie, String nazwisko, String login, String haslo, String telefon, String email) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        long nextID = -1;
        long currentId;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("SELECT iduser FROM users ");
            while (myRs.next()) {
                currentId = Long.parseLong(myRs.getString("idUser"));
                if (currentId > nextID)
                    nextID = currentId;
            }
            if (nextID == -1) {
                nextID = 0;
            }

            myStmt.executeUpdate("INSERT INTO `logindata`(`IDuser`, `login`, `password`) VALUES (" + (++nextID) + ",'" + login + "','" + haslo + "')");
            myStmt.executeUpdate("INSERT INTO `users`(`IDuser`, `login`, `imie`, `nazwisko`, `email`, `telefon`) VALUES (" + (nextID) + ",'" + login + "','" + imie + "','" + nazwisko + "','" + email + "','" + telefon + "')");
            // myStmt.executeUpdate("INSERT INTO `test`(`t`) VALUES (2)");


            currentId = ++nextID;


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }


        }
    }

    //  ZARZADZANIE KONTEM
    public static Klient getInfoAboutUser() throws SQLException {
        Map<String, String> info = new HashMap<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();


            myRs = myStmt.executeQuery("select * from users where idUser='" + currentID + "' ");
            while (myRs.next()) {
                info.put("id", String.valueOf(currentID));
                info.put("imie", myRs.getString("imie"));
                info.put("nazwisko", myRs.getString("nazwisko"));
                //info.put("login",myRs.getString("login"));
                info.put("telefon", myRs.getString("telefon"));
                info.put("email", myRs.getString("email"));
                info.put("login", myRs.getString("login"));


            }
            if (currentID == -1)
                return new Klient(-1L, "", "", -1L, "", "");


            return new Klient(Long.parseLong(info.get("id")), info.get("imie"), info.get("nazwisko"), Long.parseLong(info.get("telefon")), info.get("email"), info.get("login"));


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }


        return null;
    }

    public static void editUser(String imie, String nazwisko, String telefon, String email) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        boolean isImie = false;
        boolean isNazwisko = false;
        boolean isTelefon = false;
        boolean isEmail = false;

        String errorMessage = "";
        int errorNumber = 0;


        if (imie.trim().length() > 0)
            isImie = true;
        if (nazwisko.trim().length() > 0)
            isNazwisko = true;
        if (telefon.trim().length() > 0)
            isTelefon = true;
        if (email.trim().length() > 0)
            isEmail = true;

        if (isImie) {
            if (imie.trim().length() < 3)
                errorMessage += (++errorNumber) + ". za krótkie imię!\n";
            if (!ValidateUtilities.isText(imie.trim())) {
                errorMessage += (++errorNumber) + ". imię może zawierać tylko litery!\n";
            }
        }
        if (isNazwisko) {
            if (nazwisko.trim().length() < 3)
                errorMessage += (++errorNumber) + ". za krótkie nazwisko!\n";
            if (!ValidateUtilities.isText(nazwisko.trim())) {
                errorMessage += (++errorNumber) + ". nazwisko może zawierać tylko litery!\n";
            }
            if (isTelefon) {
                if (!ValidateUtilities.isMobilePhoneNumber(telefon.trim()))
                    errorMessage += (++errorNumber) + ". nr tel ma zawierać tylko 9 cyfr!\n";
            }
            if (isEmail) {
                if (!ValidateUtilities.validateEmail(email.trim())) {
                    errorMessage += (++errorNumber) + ". nieprawidłowy email!\n";
                }
            }

            if (errorNumber > 0)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Błąd aktualizacji danych");
                alert.setHeaderText("Błąd aktualizacji danych");
                alert.setContentText(errorMessage);

                alert.showAndWait();
            } else {

                try {
                    myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
                    myStmt = myConn.createStatement();

                    if (isImie)
                        myStmt.executeUpdate("UPDATE `users` SET `imie`='" + imie + "' WHERE `IDuser`='" + Driver.getCurrentID() + "' Limit 1");
                    if (isNazwisko)
                        myStmt.executeUpdate("UPDATE `users` SET `nazwisko`='" + nazwisko + "' WHERE `IDuser`='" + Driver.getCurrentID() + "' Limit 1");
                    if (isTelefon)
                        myStmt.executeUpdate("UPDATE `users` SET `telefon`='" + telefon + "' WHERE `IDuser`='" + Driver.getCurrentID() + "' Limit 1");
                    if (isEmail)
                        myStmt.executeUpdate("UPDATE `users` SET `email`='" + email + "' WHERE `IDuser`='" + Driver.getCurrentID() + "' Limit 1");


                } catch (Exception exc) {
                    exc.printStackTrace();
                } finally {
                    if (myRs != null) {
                        myRs.close();
                    }

                    if (myStmt != null) {
                        myStmt.close();
                    }

                    if (myConn != null) {
                        myConn.close();
                    }


                }
            }


        }
    }


    //  ZARZADZANIE TRENINGAMI
    public static Map<Integer, List<Integer>> getZapisy() throws SQLException {
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from zapisy ");
            while (myRs.next()) {
                if (resultMap.containsKey(Integer.parseInt(myRs.getString("idUser")))) {
                    List<Integer> lista;
                    lista = resultMap.get(Integer.parseInt(myRs.getString("idUser")));
                    lista.add(Integer.parseInt(myRs.getString("idTerminu")));
                    resultMap.put(Integer.parseInt(myRs.getString("idUser")), lista);
                } else {
                    List<Integer> lista = Arrays.asList(Integer.parseInt(myRs.getString("nazwa")));
                    resultMap.put(Integer.parseInt(myRs.getString("idUser")), lista);
                }

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        return resultMap;
    }

    public static List<Zapisy> getMojeZapisy(int idUser) throws SQLException {
        List<Zapisy> listResult = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from zapisy where idUser='" + idUser + "'");
            while (myRs.next()) {
                listResult.add(new Zapisy(Integer.parseInt(myRs.getString("idUser")), Integer.parseInt(myRs.getString("idTerminu"))));

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        return listResult;
    }

    public static List<Trenerzy> getTrenerzy() throws SQLException {
        List<Trenerzy> resultList = new ArrayList<>();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from trenerzy ");
            while (myRs.next()) {
                resultList.add(new Trenerzy(
                        Integer.parseInt(myRs.getString("idTrenera")),
                        myRs.getString("imie"),
                        myRs.getString("nazwisko")
                ));

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        return resultList;
    }

    public static List<Terminarz> getTerminarz() throws SQLException {
        List<Terminarz> resultList = new ArrayList<>();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from terminarz ");
            while (myRs.next()) {
                resultList.add(new Terminarz(
                        Integer.parseInt(myRs.getString("idTerminu")),
                        Integer.parseInt(myRs.getString("idTrenera")),
                        Integer.parseInt(myRs.getString("idTreningu")),
                        myRs.getString("DATA"),
                        Integer.parseInt(myRs.getString("LimitMiejsc")),
                        Integer.parseInt(myRs.getString("czasTrwania"))
                ));

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        return resultList;
    }

    public static List<ListaTreningow> getListaTreningow() throws SQLException {
        List<ListaTreningow> resultList = new ArrayList<>();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from listatreningow ");
            while (myRs.next()) {
                resultList.add(new ListaTreningow(
                        Integer.parseInt(myRs.getString("idTreningu")),
                        myRs.getString("nazwa")
                ));

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        return resultList;
    }

}




