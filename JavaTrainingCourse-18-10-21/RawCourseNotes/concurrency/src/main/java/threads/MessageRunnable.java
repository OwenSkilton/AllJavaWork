package threads;

import java.util.stream.IntStream;

public class MessageRunnable implements Runnable {

    private String message;

    public MessageRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        IntStream.range(0, 10).forEach(n -> System.out.println(Thread.currentThread().getName() + ": " + message));
    }

    public static void main(String[] args) {
        new Thread(new MessageRunnable("PING")).start();
        new Thread(new MessageRunnable("PONG")).start();
    }
}
