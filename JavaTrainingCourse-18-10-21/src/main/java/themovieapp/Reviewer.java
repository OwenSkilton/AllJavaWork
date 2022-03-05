package themovieapp;

import java.util.concurrent.atomic.AtomicLong;

public class Reviewer {
    private String id;
    private String name;
    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }

    public Reviewer(String name) {
        this.id = createID();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
