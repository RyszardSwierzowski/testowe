package user;

import java.time.LocalDateTime;
import java.util.Map;

public class Klient {

    long id;
    long numerKontaktowy;
    String imie, nazwisko ,adresEmail, login;

    public Klient(long id, String imie, String nazwisko, long numerKontaktowy,  String adresEmail, String login) {
        this.id = id;
        this.numerKontaktowy = numerKontaktowy;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresEmail = adresEmail;
        this.login=login;
    }

    public long getId() {
        return id;
    }

    public long getNumerKontaktowy() {
        return numerKontaktowy;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public String getLogin() {
        return login;
    }





}
