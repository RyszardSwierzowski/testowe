import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sanbox {


    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        lista.add("das");
        lista.add("das");
        lista.add("das");
        lista.add("das");

        lista.set(0,1);
        lista.remove(0);

        System.out.println(lista.get(0));
    }
}
