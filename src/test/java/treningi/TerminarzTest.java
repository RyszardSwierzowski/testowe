package treningi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TerminarzTest {

    @Test
    void getInfoAboutTerminById(){
        List<Terminarz> terminarzList = new ArrayList<>();

        terminarzList.add(new Terminarz(1,1,2,"",1,1));
        terminarzList.add(new Terminarz(2,1,2,"",1,1));
        terminarzList.add(new Terminarz(3,1,2,"",1,1));
        terminarzList.add(new Terminarz(4,1,2,"",1,1));

        assertEquals(new Terminarz(3,1,2,"",1,1).toString(),Terminarz.getInfoAboutTerminById(3,terminarzList).toString());
    }

}