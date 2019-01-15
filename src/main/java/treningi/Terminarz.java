package treningi;

import java.util.List;

public class Terminarz {
    private int idTerminu;
    private int idTrenera;
    private int idTreningu;
    private String data;
    private int limit;
    private int czas;

    public Terminarz(int idTerminu, int idTrenera, int idTreningu, String data, int limit, int czas) {
        this.idTerminu = idTerminu;
        this.idTrenera = idTrenera;
        this.idTreningu = idTreningu;
        this.data = data;
        this.limit = limit;
        this.czas = czas;
    }
    public static Terminarz getInfoAboutTerminById(int id, List<Terminarz> terminarzList){
        for(Terminarz t : terminarzList)
        {
            if(t.getIdTreningu()==id)
                return t;
        }

        return new Terminarz((-1),(-1),(-1),"",(-1),(-1));



    }
    public int getIdTerminu() {
        return idTerminu;
    }

    public int getIdTrenera() {
        return idTrenera;
    }

    public int getIdTreningu() {
        return idTreningu;
    }

    public String getData() {
        return data;
    }

    public int getLimit() {
        return limit;
    }

    public int getCzas() {
        return czas;
    }
}
