package observer;

import org.junit.jupiter.api.Test;

public class BieberObservableTest {

    @Test
    public void testBieberObservable() {
        var obervable = new BieberObservable();
        var observer1 = new BieberObserver("Fred");
        var observer2 = new BieberObserver("Rachel");
        var observer3 = new BieberObserver("George");
        obervable.subscribe(observer1);
        obervable.subscribe(observer2);
        obervable.subscribe(observer3);
        obervable.setInaneComment("I just had my hair cut");
    }
}
