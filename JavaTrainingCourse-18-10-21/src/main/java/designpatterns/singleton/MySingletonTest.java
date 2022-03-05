package designpatterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;


public class MySingletonTest {

    @Test
    public void testMySingletonIsASingleton(){
        var mySingleton1 = MySingleton.getInstance();
        var mySingleton2 = MySingleton.getInstance();
        // assertTrue(mySingleton1 == mySingleton2)
        // assertSame is used to test for equality of reference; it is equal to the above using ==
        // In this case assertEquals would be the same test be because overriding equals to check for content is common practice,
            // it is not an appropriate comparison in terms of code readability
        assertSame(mySingleton1, mySingleton2);
    }
}
