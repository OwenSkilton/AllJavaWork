package designpatterns.observer;

import java.util.ArrayList;

public class BieberObservable {

    private String inaneComment;
    private ArrayList<BieberObserver> observers;

    public BieberObservable(){
        observers = new ArrayList<BieberObserver>();
    }

    public void subscribe(BieberObserver observer){
        observers.add(observer);
    }

    public String getInaneComment() {
        return inaneComment;
    }

    // Each inane comment made notifies every observer wihtin the array list
    public void setInaneComment(String inaneComment) {
        this.inaneComment = inaneComment;
        for (var observer : observers){
            observer.notify(inaneComment);
        }
    }
}
