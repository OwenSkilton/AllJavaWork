package designpatterns.factory;

import org.junit.jupiter.api.Test;

public class MyListTest {

    @Test
    public void testMyListCreationWithoutFactory() {
        var myList = new MyList(3);
        myList.add(10);
        myList.add(20);
        myList.add(30);
    }

    @Test
    public void testMyListCreationWithFactory(){
        var myList = MyList.of(10,20,30);
    }
}
