package concurrency.threads;

public class MessageRunnable implements Runnable {

    private String message;

    public MessageRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(Thread.currentThread().getName() + ": " + message);
    }

    public static void main(String[] args) {
        new Thread(new MessageRunnable("PING")).start();
        new Thread(new MessageRunnable("PONG")).start();
    }
}