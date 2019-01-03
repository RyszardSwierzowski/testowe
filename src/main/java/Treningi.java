import java.time.LocalDateTime;

public class Treningi {

    private long idTrening;
    private String nazwa;
    private LocalDateTime termin;
    private long idTrenera;
    private TypyZajec typZajec;


    public Treningi(long idTrening, String nazwa, LocalDateTime termin, long idTrenera, TypyZajec typZajec) {
        this.idTrening = idTrening;
        this.nazwa = nazwa;
        this.termin = termin;
        this.idTrenera = idTrenera;
        this.typZajec = typZajec;
    }
}
