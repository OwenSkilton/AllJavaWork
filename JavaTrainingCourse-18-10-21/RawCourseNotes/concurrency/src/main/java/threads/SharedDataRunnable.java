package threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SharedDataRunnable implements Runnable {

    // This field exists inside an object shared by two threads
    // It is in danger of corruption
    // Even though numbers are effectively immutable, the variable itself can be reassigned
    // Instance fields can be made thread-safe by ensuring they are final and immutable
    // There are several options for synchronising access to shared data:
    // - Atomic classes
    // - Synchronized blocks
    private int x;
    // private AtomicInteger x = new AtomicInteger(0);

    @Override
    public void run() {
        // x++ is NOT an atomic operation
        // once compiled into bytecode x++ look like this:
        // READ X
        // READ 1
        // INPLACE ADD
        // WRITE X
        // Problems occur when both threads read before either one writes

        // NB: synchronizing the code here renders the threading redundant
        synchronized (this) {
            IntStream.range(0, 500).forEach(n -> x++);
        }
        // IntStream.range(0, 500).forEach(n -> x.getAndIncrement());
    }

    public int getX() {
        return x;
        // return x.get();
    }

    public static void main(String[] args) {
        var sharedDataRunnable = new SharedDataRunnable();
        var t1 = new Thread(sharedDataRunnable);
        var t2 = new Thread(sharedDataRunnable);
        t1.start();
        t2.start();
        var threadsComplete = false;
        while (!threadsComplete) {
            try {
                t1.join();
                t2.join();
                threadsComplete = true;
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println(sharedDataRunnable.getX());
    }
}
