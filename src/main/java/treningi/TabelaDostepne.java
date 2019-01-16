package treningi;

import controllers.MainViewFinal;
import javafx.scene.control.Button;
import jdbcDriver.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabelaDostepne {
    private final int lp;
    private final String nazwa,termin,trener,czas;
    private final Button button;
    public static List listaDostepneZBazy;
    public static List<Integer> listaIdTerminow= new ArrayList<>();

    static {
        try {listaDostepneZBazy = convertTerminarzToTabelaDostepne(Driver.getTerminarz(),Driver.getMojeZapisy(Driver.getCurrentID()));}
        catch (SQLException e) {e.printStackTrace();}
    }




    public TabelaDostepne(int lp, String nazwa, String termin, String trener, String czas, Button button) {
        this.lp = lp;
        this.nazwa = nazwa;
        this.termin = termin;
        this.trener = trener;
        this.czas = czas;
        this.button = button;

        button.setOnAction(e->
        {

            try {
                Driver.addNewTraininigsForUser(this.getLp()-1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


            listaIdTerminow.remove(this.getLp()-1);


            MainViewFinal.listaDostepnych.remove(this.getLp()-1);
            for(int i = this.lp-1; i< MainViewFinal.listaDostepnych.size(); i++)
            {

                TabelaDostepne curr = (TabelaDostepne)  MainViewFinal.listaDostepnych.get(i);
                TabelaDostepne temp = new TabelaDostepne((i+1),curr.nazwa,curr.termin,curr.trener,curr.czas,new Button("Zapisz sie"));
                MainViewFinal.listaDostepnych.set(i,temp);

            }

        });
    }
    public static List<TabelaDostepne> convertTerminarzToTabelaDostepne(List<Terminarz> terminarz, List<Zapisy> zapisane) throws SQLException {
        List<TabelaDostepne> result = new ArrayList<>();

        boolean isReady=false; // czy idTerminu jest już zapisane
        int licznikLp=1;

        List myTrainings = new ArrayList();
        List<Terminarz> terminarzFromDataBase = Driver.getTerminarz();
        List<Zapisy> myTerminyFromDataBase   = Driver.getMojeZapisy(Driver.getCurrentID());
        List<ListaTreningow> allTrainingsFromDataBase = Driver.getListaTreningow();
        List<Trenerzy> trainersListFromDataBase = Driver.getTrenerzy();

        for(int t=0;t<terminarz.size();t++)
        {
            isReady=false;
            Terminarz tempTerminarz = terminarz.get(t);

            int idTerminu=terminarz.get(t).getIdTerminu();

            for(Zapisy z : zapisane)
            {
                if(idTerminu==z.getIdTerminu())
                {
                    isReady=true;
                }
            }

            if(isReady==false)
            {
                String nazwa  = ListaTreningow.getNameById(tempTerminarz.getIdTreningu(),allTrainingsFromDataBase) + "[" + String.valueOf(tempTerminarz.getIdTerminu()) + "]";
                String termin = String.valueOf(tempTerminarz.getData());
                String trener = Trenerzy.getFullNameById(tempTerminarz.getIdTrenera(),trainersListFromDataBase) + " " + String.valueOf(tempTerminarz.getIdTrenera());
                String czas   = String.valueOf(tempTerminarz.getCzas());
                result.add(new TabelaDostepne((licznikLp++),nazwa,termin,trener,czas,new Button("Zapisz się")));
                listaIdTerminow.add(tempTerminarz.getIdTerminu());
            }
        }
        return result;
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
