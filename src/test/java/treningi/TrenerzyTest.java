package treningi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrenerzyTest {

    @Test
    void getFullNameById() {
        List<Trenerzy> listaTrenerow = new ArrayList<>();

        listaTrenerow.add(new Trenerzy(1,"Jan","Kowalski"));
        listaTrenerow.add(new Trenerzy(2,"Adam","Nowak"));

        assertEquals("Jan Kowalski",Trenerzy.getFullNameById(1,listaTrenerow));

    }




}