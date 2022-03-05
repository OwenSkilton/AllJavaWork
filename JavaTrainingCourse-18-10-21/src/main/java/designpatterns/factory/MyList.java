package designpatterns.factory;

// Factory method is a creational pattern
// Used to simplify the creation of object that would otherwise occcupy multiple lines
public class MyList {

    private Object[] elements;
    private int capacity;
    private int numElements;

    public MyList(int capacity){
        elements = new Object[capacity];
        this.capacity = capacity;
        numElements = 0;
    }

    public void add (Object object){
        if(numElements < capacity){
            elements[numElements++] = object;
        }
    }

    public Object get(int index){
        if (index < numElements) {
            return elements;
        }
        else {
            return null;
        }
    }

    // Factory that is a static method that returns a MyList Object
    // It encapsulates the logic association with creating and adding a small number of elements
    public static MyList of(Object... objects){
        var myList = new MyList(objects.length);
        for (var object :objects){
            myList.add(object);
        }
        return myList;
    }
}
