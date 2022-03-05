package functionalprogramming;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionalInterfaceTest {

    // A functional interface is one that has only one abstract method
    // Lambdas can be used to create implementations of functional interfaces ONLY
    // The java.util.function package has a suite of functional interfaces that cover most use cases

    @Test
    public void testPredicate() {

        // A Predicate is a functional interface that has one method that looks like this:
        // boolean test(T t);
        Predicate<String> p1 = s -> s.length() >= 3;
        assertTrue(p1.test("Hello"));
    }

    @Test
    public void testFunction() {

        // A Function is a functional interface that has one method that looks like this:
        // R apply(T t);
        Function<String, Character> f1 = s -> s.charAt(0);
        assertEquals('H', f1.apply("Hello"));
    }

    @Test
    public void testConsumer() {

        // A Consumer is a functional interface that has one method that looks like this:
        // void accept(T t);
        Consumer<String> c1 = s -> System.out.println(s);
        c1.accept("Hello");
    }

    @Test
    public void testSupplier() {

        // A Supplier is a functional interface that has one method that looks like this:
        // T get();
        Supplier<String> s1 = () -> "Hello";
        assertEquals("Hello", s1.get());
    }
}
