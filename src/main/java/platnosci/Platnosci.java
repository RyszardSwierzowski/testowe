package platnosci;

import java.time.LocalDate;

public class Platnosci {
    private int idUser;
    private String status;
    private long karta;
    private String termin;

    public Platnosci(int idUser, String status, long karta, String termin) {
        this.idUser = idUser;
        this.status = status;
        this.karta = karta;
        this.termin = termin;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getStatus() {
        return status;
    }

    public long getKarta() {
        return karta;
    }

    public String getTermin() {
        return termin;
    }
}
