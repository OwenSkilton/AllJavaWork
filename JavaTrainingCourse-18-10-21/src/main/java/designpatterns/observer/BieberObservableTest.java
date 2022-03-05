package designpatterns.observer;

import org.junit.jupiter.api.Test;

public class BieberObservableTest {

    @Test
    public void testBieberObservable(){
        var observable = new BieberObservable();

        var observer1 = new BieberObserver("Fred");
        var observer2 = new BieberObserver("Miley");
        var observer3 = new BieberObserver("Rachel");

        observable.subscribe(observer1);
        observable.subscribe(observer2);
        observable.subscribe(observer3);

        observable.setInaneComment("I had breakfast");
    }
}
