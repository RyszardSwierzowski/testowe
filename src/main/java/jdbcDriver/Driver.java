package jdbcDriver;



import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Driver {


    private static long currentID=-1;

    public static long getCurrentID() {
        return currentID=-1;
    }


        // LOGOWANIE REJESTRACJA
    public static boolean tryToLogIn(String log, String pass) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try
        {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from logindata where password='"+pass+"' and login='"+log+"'");
            while (myRs.next()) {
                //System.out.println(myRs.getString("idUser"));
                currentID=Long.parseLong(myRs.getString("idUser"));
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
    public static boolean tryToAddANewUser(String log, String email) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try
        {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();



            myRs = myStmt.executeQuery("select * from users where login='"+log+"' and email='"+email+"'   ");
            while (myRs.next()) {
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
    public static void addNewUserToDataBase(String imie,String nazwisko, String login,String haslo, String telefon, String email) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        long nextID=-1;
        long currentId;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("SELECT iduser FROM users ");
            while (myRs.next()) {
                currentId = Long.parseLong(myRs.getString("idUser"));
                if(currentId>nextID)
                    nextID=currentId;
            }
            if(nextID==-1){
                nextID=0;
            }

            myStmt.executeUpdate("INSERT INTO `logindata`(`IDuser`, `login`, `password`) VALUES ("+(++nextID)+",'"+login+"','"+haslo+"')");
            myStmt.executeUpdate("INSERT INTO `users`(`IDuser`, `login`, `imie`, `nazwisko`, `email`, `telefon`) VALUES ("+(nextID)+",'"+login+"','"+imie+"','"+nazwisko+"','"+email+"','"+telefon+"')");
           // myStmt.executeUpdate("INSERT INTO `test`(`t`) VALUES (2)");


            currentId=++nextID;


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
    public static user.Klient getInfoAboutUser() throws SQLException {
        Map<String,String> info = new HashMap <>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try
        {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();




            myRs = myStmt.executeQuery("select * from users where idUser='"+currentID+"' ");
            while (myRs.next()) {
                info.put("id",String.valueOf(currentID));
                info.put("imie",myRs.getString("imie"));
                info.put("nazwisko",myRs.getString("nazwisko"));
                //info.put("login",myRs.getString("login"));
                info.put("telefon",myRs.getString("telefon"));
                info.put("email",myRs.getString("email"));
                info.put("login",myRs.getString("login"));


            }
            if(currentID==-1)
                return new user.Klient(-1L,"","",-1L,"","");


            return new user.Klient(Long.parseLong(info.get("id")),info.get("imie"),info.get("nazwisko"),Long.parseLong(info.get("telefon")),info.get("email"), info.get("login"));


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




    /*
    public static long getCurrentId(String login) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try
        {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root", "");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from logindata where login='"+login+"'");
            while (myRs.next()) {
                //System.out.println(myRs.getString("idUser"));

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
        return 0L;
    }
*/
//    public static void main(String[] args) throws SQLException {
//
//        Connection myConn = null;
//        Statement myStmt = null;
//        ResultSet myRs = null;
//
//        //String sqlQueryy="";
//
//
//
//        try {
//            // 1. Get a connection to database
//            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt", "root" , "");
//
//            // 2. Create a statement
//            myStmt = myConn.createStatement();
//
//            // 3. Execute SQL query
//            myRs = myStmt.executeQuery("select * from logindata");
//
//            // 4. Process the result set
//            while (myRs.next()) {
//                System.out.println(myRs.getString("id") );
//            }
//        }
//        catch (Exception exc) {
//            exc.printStackTrace();
//        }
//        finally {
//            if (myRs != null) {
//                myRs.close();
//            }
//
//            if (myStmt != null) {
//                myStmt.close();
//            }
//
//            if (myConn != null) {
//                myConn.close();
//            }
//        }
//    }

    }