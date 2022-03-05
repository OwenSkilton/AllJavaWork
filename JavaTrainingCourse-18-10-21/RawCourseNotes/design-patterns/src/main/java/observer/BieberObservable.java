package observer;

import java.util.ArrayList;

public class BieberObservable {

    private String inaneComment;
    private ArrayList<BieberObserver> observers;

    public BieberObservable() {
        observers = new ArrayList<>();
    }

    public void subscribe(BieberObserver observer) {
        observers.add(observer);
    }

    public String getInaneComment() {
        return inaneComment;
    }

    public void setInaneComment(String inaneComment) {
        this.inaneComment = inaneComment;
        for (var observer : observers) {
            observer.notify(inaneComment);
        }
    }
}
