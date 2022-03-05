package factory;

// The factory method pattern is a creational pattern
// It is used to simplify the creation of objects that would otherwise occupy multiple lines
public class MyList {

    private Object[] elements;
    private int capacity;
    private int numElements;

    public MyList(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
        numElements = 0;
    }

    public void add(Object object) {
        if (numElements < capacity) {
            elements[numElements++] = object;
        }
    }

    public Object get(int index) {
        if (index < numElements) {
            return elements[index];
        } else {
            return null;
        }
    }

    // The factory is a static method that returns a MyList object
    // It encapsulates the logic assoc. with creating and adding a small number of elements
    public static MyList of(Object... objects) {
        var myList = new MyList(objects.length);
        for (var object : objects) {
            myList.add(object);
        }
        return myList;
    }
}
