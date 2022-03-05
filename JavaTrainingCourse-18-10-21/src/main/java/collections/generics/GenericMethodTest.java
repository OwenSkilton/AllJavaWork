package collections.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class GenericMethodTest {

    // Pass in any array object and covert to an array list
    public static ArrayList arrayToList(Object[] array){
        var list = new ArrayList();
        for (var element : array) {
            list.add(element);
        }
        return list;
    }

    @Test
    public void testArrayToList() {
        var array = new String[] {"All", "the", "world's", "a", "stage"};
        var list = arrayToList(array);
        // The type information has been lost inside the method
        var firstElement = list.get(0);
    }

    // Diamond operator must precede the return type
    public static <T> ArrayList<T> arrayToListGeneric(T[] array){
        var list = new ArrayList<T>();
        Collections.addAll(list, array);
        return list;
    }

    @Test
    public void testArrayToListGeneric() {
        var array = new String[] {"All", "the", "world's", "a", "stage"};
        // The compiler can infer the type with which to replace T by looking at the type of the array
        var list = arrayToListGeneric(array);
        // The type information has been lost inside the method
        var firstElement = list.get(0);
    }
}
