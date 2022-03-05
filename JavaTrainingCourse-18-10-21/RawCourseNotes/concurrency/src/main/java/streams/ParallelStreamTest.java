package streams;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ParallelStreamTest {

    @Test
    public void testRegularStream() {
        List.of(1, 2, 3, 4, 5)
                .stream()
                .peek(n -> System.out.println(Thread.currentThread().getName()))
                .forEach(n -> System.out.println(n));
    }

    @Test
    public void testParallelStream() {
        List.of(1, 2, 3, 4, 5)
                .parallelStream()
                .peek(n -> System.out.println(Thread.currentThread().getName()))
                .forEach(n -> System.out.println(n));
    }
}
