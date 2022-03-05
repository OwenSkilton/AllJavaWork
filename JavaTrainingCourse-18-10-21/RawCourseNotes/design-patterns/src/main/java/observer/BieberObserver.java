package observer;

// This could be improved by making the class an abstraction
// That way the implementations could react to the inane comment in whatever they choose
public class BieberObserver {

    private String name;

    public BieberObserver(String name) {
        this.name = name;
    }

    public void notify(String inaneComment) {
        System.out.println("Bieber observer " + name + " notified of inane comment: " + inaneComment);
    }
}
