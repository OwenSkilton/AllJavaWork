package threads;

public class SleepAndJoin {

    public static void main(String[] args) {

        var thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // ignore
            }
            System.out.println("Hello world");
        });
        thread.start();

        // Put the main thread to sleep for 1 second
        // NB: don't use sleep to attempt to order your threads
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // ignore
//        }

        // Force the main thread to wait for the spawned thread to finish
        var threadComplete = false;
        while (!threadComplete) {
            try {
                thread.join();
                threadComplete = true;
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Goodbye");
    }
}
