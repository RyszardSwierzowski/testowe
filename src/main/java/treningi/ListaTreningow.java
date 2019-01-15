package treningi;

import java.util.List;

public class ListaTreningow {
    private int idTreningu;
    private String nazwa;

    public ListaTreningow(int idTreningu, String nazwa) {
        this.idTreningu = idTreningu;
        this.nazwa = nazwa;
    }

    public static String getNameById(int idTreningu, List<ListaTreningow> listOfAllTrainings)
    {
        for(ListaTreningow t : listOfAllTrainings){
            if(t.idTreningu==idTreningu)
                return t.getNazwa();
        }
        return "Brak nazwy";
    }

    public int getIdTreningu() {
        return idTreningu;
    }

    public String getNazwa() {
        return nazwa;
    }
}
