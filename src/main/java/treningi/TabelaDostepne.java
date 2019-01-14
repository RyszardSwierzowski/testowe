package treningi;

import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;

public class TabelaDostepne {
    private final int lp;
    private final String nazwa,termin,trener,czas;
    private final Button button;
    public static List listaDostepneZBazy = Arrays.asList(// todo lista ma być na podstawie bazy danych
            new TabelaZapisane(1,"nazwaZapis","termin","trener","czas",new Button("Wypisz sie")),
            new TabelaZapisane(2,"nazwaZapis","termin","trener","czas",new Button("Wypisz sie")),
            new TabelaZapisane(3,"nazwaZapis","termin","trener","czas",new Button("Wypisz sie"))
    );

    public TabelaDostepne(int lp, String nazwa, String termin, String trener, String czas, Button button) {
        this.lp = lp;
        this.nazwa = nazwa;
        this.termin = termin;
        this.trener = trener;
        this.czas = czas;
        this.button = button;

        button.setOnAction(e->
        {


        });
    }

    public int getLp() {
        return lp;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getTermin() {
        return termin;
    }

    public String getTrener() {
        return trener;
    }

    public String getCzas() {
        return czas;
    }

    public Button getButton() {
        return button;
    }

    @Override
    public String toString() {
        return "TabelaDostepne{" +
                "lp=" + lp  ;
    }
}
