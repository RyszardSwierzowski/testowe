package treningi;

public class Zapisy {
    private int idUser;
    private int idTerminu;

    public Zapisy(int idUser, int idTerminu) {
        this.idUser = idUser;
        this.idTerminu = idTerminu;
    }




    public int getIdUser() {
        return idUser;
    }

    public int getIdTerminu() {
        return idTerminu;
    }
}
