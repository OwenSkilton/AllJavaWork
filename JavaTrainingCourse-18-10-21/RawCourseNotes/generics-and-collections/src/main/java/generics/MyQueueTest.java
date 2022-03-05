package generics;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyQueueTest {

    @Test
    public void testPushAndPop() throws Exception {
        var queue = new MyQueue(3);
        queue.push("Hello");
        queue.push("Hi");
        queue.push("G'day");
        assertEquals("Hello", queue.pop());
    }

    @Test
    public void testPushToFullQueue() throws Exception {
        var queue = new MyQueue(3);
        queue.push("Hello");
        queue.push("Hi");
        queue.push("G'day");
        try {
            queue.push("Bonjour");
            fail("The queue didn't throw an exception when pushing when full");
        } catch (Exception e) {
            // We expect an exception
        }
    }

    @Test
    public void testPopFromEmptyQueue() {
        var queue = new MyQueue(3);
        try {
            queue.pop();
            fail("The queue didn't throw an exception when popping when empty");
        } catch (Exception e) {
            // We expect an exception
        }
    }

    @Test
    public void testQueueCanContainAnything() throws Exception {
        var queue = new MyQueue(3);
        // As MyQueue stores Objects we can put anything in it thanks to polymorphism
        queue.push("Hello");
        queue.push(42); // <!-- the primitive number is automatically wrapped in an object (Autoboxing)
        queue.push(LocalDate.now());
        // The flip side is that when we pop elements we get Objects back, not Strings, Integers and LocalDates
        var el1 = queue.pop();
        if (el1 instanceof String) {
            ((String) el1).toUpperCase();
        }
    }

    @Test
    public void testQueueWithTypeParam() throws Exception {
        // With a type param MyQueue can store only Strings
        var queue = new MyQueue<String>(3);
        queue.push("Hello");
        // queue.push(42);
        // queue.push(LocalDate.now());
        // The flip side is that when we pop elements the type info is maintained and I needn't perform an instance check
        var el1 = queue.pop();
        el1.toUpperCase();
    }
}
