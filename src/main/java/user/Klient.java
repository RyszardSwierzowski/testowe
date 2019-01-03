package user;

import java.time.LocalDateTime;
import java.util.Map;

public class Klient extends User {
    private Map<LocalDateTime,String> zarezerwowaneZajecia;

    public Klient(long id, String imie, String nazwisko, long numerKontaktowy, String adresEmail, String login) {
        super(id, imie, nazwisko, numerKontaktowy, adresEmail, login);
    }


    public Klient(long id, String imie, String nazwisko, long numerKontaktowy, String adresEmail, String login, Map<LocalDateTime, String> zarezerwowaneZajecia) {
        super(id, imie, nazwisko, numerKontaktowy, adresEmail, login);
        this.zarezerwowaneZajecia = zarezerwowaneZajecia;
    }
}
