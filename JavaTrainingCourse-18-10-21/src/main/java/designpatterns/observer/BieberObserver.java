package designpatterns.observer;

public class BieberObserver {

    private String name;

    public BieberObserver(String name) {
        this.name = name;
    }

    public void notify(String inaneComment){
        System.out.println("Bieber observer " + name + " notified of inane comment: " + inaneComment);
    }
}
