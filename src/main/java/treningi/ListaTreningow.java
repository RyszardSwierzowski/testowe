package treningi;

public class ListaTreningow {
    private int idTreningu;
    private String nazwa;

    public ListaTreningow(int idTreningu, String nazwa) {
        this.idTreningu = idTreningu;
        this.nazwa = nazwa;
    }

    public int getIdTreningu() {
        return idTreningu;
    }

    public String getNazwa() {
        return nazwa;
    }
}
