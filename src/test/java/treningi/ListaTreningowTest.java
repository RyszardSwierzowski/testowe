package treningi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaTreningowTest {

    @Test
    void getNameById() {
        List<ListaTreningow> listOfAllTrainings = new ArrayList<>();
        listOfAllTrainings.add(new ListaTreningow(1,"a"));
        listOfAllTrainings.add(new ListaTreningow(2,"b"));
        listOfAllTrainings.add(new ListaTreningow(3,"aw"));

        assertEquals("b", ListaTreningow.getNameById(2,listOfAllTrainings));

    }






}