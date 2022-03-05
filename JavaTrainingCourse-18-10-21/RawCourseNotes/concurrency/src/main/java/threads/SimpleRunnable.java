package threads;

// Implementing Runnable has the same effect as extending Thread
// But it means you're forced to override run and you're free to extend some other class
// FYI Runnable is a functional interface
public class SimpleRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Hello world");
    }

    public static void main(String[] args) {
        var simpleRunnable = new SimpleRunnable();
        var simpleThread = new Thread(simpleRunnable); // <!-- the Runnable is passed to the Thread constructor
        simpleThread.start();
        System.out.println(Thread.currentThread().getName() + ": Goodbye");
    }
}
