package treningi;

import jdbcDriver.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DostępneTreningiTabele {
    private final int Lp;
    private final String Nazwa;
    private final String Termin;
    private final String Trener;
    private final int Czas;
    private final int Limit;

    public DostępneTreningiTabele(int lp, String nazwa, String termin, String trener, int czas) {
        this.Lp = lp;
        this.Nazwa = nazwa;
        this.Termin = termin;
        this.Trener = trener;
        this.Czas = czas;
        this.Limit=0;
    }

    public DostępneTreningiTabele(int lp, String nazwa, String termin, String trener, int czas, int limit) {
        Lp = lp;
        Nazwa = nazwa;
        Termin = termin;
        Trener = trener;
        Czas = czas;
        Limit = limit;
    }

    public static List<DostępneTreningiTabele> generujMojeTreningi(List<Zapisy> lista, int idUser) throws SQLException {
        List<DostępneTreningiTabele> resultList= new ArrayList<>();
        int currentLP=0;

        List<Terminarz> terminarz =Driver.getTerminarz();
        List<ListaTreningow> listaTreningow = Driver.getListaTreningow();
        List<Trenerzy> listaTrenerow = Driver.getTrenerzy();
        String nazwa="";
        String terminZajec="";
        String trener="";
        int czas=-1;



        for(Zapisy elem : lista)
        {
            if(elem.getIdUser()==idUser)
            {
                // OKREŚLENIE NAZWY TRENINGU
                for( Terminarz termin : terminarz){
                    if(termin.getIdTerminu()==elem.getIdTerminu()){
                        for(ListaTreningow listaTren : listaTreningow){
                            if(termin.getIdTreningu()==listaTren.getIdTreningu()){
                                nazwa=listaTren.getNazwa();
                            }
                        }
                    }
                }
                // OKREŚLENIE  POZOSTAŁYCH PARAMETRÓW
                for( Terminarz termin : terminarz){
                    if(termin.getIdTerminu()==elem.getIdTerminu()){
                        terminZajec=termin.getData();
                        trener =Trenerzy.getTrenerNameAndSurname(termin.getIdTrenera());
                        czas=termin.getCzas();
                    }
                }

                resultList.add( new DostępneTreningiTabele(++currentLP,nazwa,terminZajec,trener,czas));
            }
        }
        return resultList;
    }

    public int getLp() {
        return Lp;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public String getTermin() {
        return Termin;
    }

    public String getTrener() {
        return Trener;
    }

    public int getCzas() {
        return Czas;
    }
}
