package treningi;


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


    public static String getFullNameById(int id , List<Trenerzy> listaTrenerow)
    {
        for(Trenerzy t : listaTrenerow)
        {
            if(t.getIdTrenera()==id)
                return t.toString();
        }
        return "brak danych o trenerze";
    }

    public int getIdTrenera() {
        return idTrenera;
    }

    @Override
    public String toString() {
        return imie + " " +nazwisko;
    }
}
