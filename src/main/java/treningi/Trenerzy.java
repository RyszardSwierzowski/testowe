package treningi;



import jdbcDriver.Driver;

import java.sql.SQLException;
import java.util.List;

public class Trenerzy {
    private int idTrenera;
    private String imie;
    private String nazwisko;

    public Trenerzy(int idTrenera, String imie, String nazwisko) {
        this.idTrenera = idTrenera;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public static String getTrenerNameAndSurname(int idTrenera) throws SQLException {
        List<Trenerzy> listaTrenerow = Driver.getTrenerzy();
        for(Trenerzy t:listaTrenerow){
            if(idTrenera==t.idTrenera)
            {
                return t.imie+" "+t.nazwisko;
            }
        }
        return " Brak danych";
    }

}
