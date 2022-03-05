package executors;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class SimpleExecutorTest {

    // An ExecutorService is a tool that simplifies thread creation and management
    // There exists a variety of ExecutorServices - single thread, fixed pool, cached pool etc.
    // The Executor will create the Thread object and call start for me

    @Test
    public void testSimpleExecutor() {
        // var executor = Executors.newSingleThreadExecutor();
        // var executor = Executors.newFixedThreadPool(2);
        var executor = Executors.newCachedThreadPool(); // <!-- will create Threads on demand
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + ": Hello world"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + ": How are you?"));
        System.out.println(Thread.currentThread().getName() + ": Goodbye");
        executor.shutdown(); // <!-- will wait for existing threads to complete but won't permit new tasks to be executed
    }

    @Test
    public void testExecutorWithFutures() {
        var executor = Executors.newSingleThreadExecutor();
        // A Future is an object that WILL contain a value/flag once the task is complete
        // var future = executor.submit(() -> System.out.println("Hello world"));
        // A Callable is a functional interface that is identical to Supplier; it accepts no args and returns a value
        var future = executor.submit(() -> "Hello world");
        // Force the main thread to wait for the task to be completed
        var taskComplete = false;
        while (!taskComplete) {
            try {
                var message = future.get(); // <!-- get is blocking
                System.out.println(message);
                taskComplete = true;
            } catch (Exception e) {
                // ignore
            }
        }
        System.out.println("Goodbye");
        executor.shutdown();
    }
}
