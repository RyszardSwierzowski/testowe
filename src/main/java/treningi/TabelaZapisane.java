package treningi;

import controllers.MainViewFinal;
import javafx.scene.control.Button;
import jdbcDriver.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TabelaZapisane {
    private final int lp;
    private final String nazwa,termin,trener,czas;
    private final Button button;
    public static List listaZapisaneZBazy;// zpis z bazy rzutowany na TabelaZapisane;
    //public static List<Integer> listaIdTerminow= new ArrayList<>();

    static {
            try {listaZapisaneZBazy = setListOfTabelaZapisaneFromDataBase();}
            catch (SQLException e) {e.printStackTrace();}
            }


    public TabelaZapisane(int lp, String nazwa, String termin, String trener, String czas, Button button) {
        this.lp = lp;
        this.nazwa = nazwa;
        this.termin = termin;
        this.trener = trener;
        this.czas = czas;
        this.button = button;

        button.setOnAction(e->
        {
            try {
                Driver.deleteTrainingForUser(this.getLp()-1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            MainViewFinal.listaZapis.remove(this.getLp()-1);
            for(int i = this.lp-1; i< MainViewFinal.listaZapis.size(); i++)
            {

                TabelaZapisane curr = (TabelaZapisane)  MainViewFinal.listaZapis.get(i);
                TabelaZapisane temp = new TabelaZapisane((i+1),curr.nazwa,curr.termin,curr.trener,curr.czas,new Button("Wypisz się"));
                MainViewFinal.listaZapis.set(i,temp);

            }
        });
    }
    public static List setListOfTabelaZapisaneFromDataBase() throws SQLException {
        List<Integer> mojeIdTerminow = new ArrayList<>();
        List myTrainings = new ArrayList();
        List<Terminarz> terminarzFromDataBase = Driver.getTerminarz();
        List<Zapisy> myTerminyFromDataBase   = Driver.getMojeZapisy(Driver.getCurrentID());
        List<ListaTreningow> allTrainingsFromDataBase = Driver.getListaTreningow();
        List<Trenerzy> trainersListFromDataBase = Driver.getTrenerzy();

        for( Zapisy x:  myTerminyFromDataBase ) // przepisanie z zapisanych juz treningow samych idTerminu
        {
            mojeIdTerminow.add(x.getIdTerminu());
//            listaIdTerminow.add(x.getIdTerminu());
        }


        for(int i=0;i<mojeIdTerminow.size();i++){
            Terminarz tempTerminarz = Terminarz.getInfoAboutTerminById(mojeIdTerminow.get(i),terminarzFromDataBase);

            String nazwa  = ListaTreningow.getNameById(tempTerminarz.getIdTreningu(),allTrainingsFromDataBase) + "[" + String.valueOf(tempTerminarz.getIdTerminu()) + "]";
            String termin = String.valueOf(tempTerminarz.getData());
            String trener = Trenerzy.getFullNameById(tempTerminarz.getIdTrenera(),trainersListFromDataBase) + " " + String.valueOf(tempTerminarz.getIdTrenera());
            String czas   = String.valueOf(tempTerminarz.getCzas());
            myTrainings.add(
                    new TabelaZapisane((i+1),nazwa,termin,trener,czas,new Button("Wypisz się"))
            );
        }

        return myTrainings;
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
        return "TabelaZapisane{" +
                "lp=" + lp  ;
    }
}
