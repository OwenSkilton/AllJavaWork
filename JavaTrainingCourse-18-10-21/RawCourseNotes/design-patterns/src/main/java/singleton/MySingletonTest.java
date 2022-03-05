package singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySingletonTest {

    @Test
    public void testMySingletonIsASingleton() {
        var mySingleton1 = MySingleton.getInstance();
        var mySingleton2 = MySingleton.getInstance();
        // assertTrue(mySingleton1 == mySingleton2);
        // assertSame is used to test for equality of reference; it is equivalent to the above using ==
        assertSame(mySingleton1, mySingleton2);
    }
}
