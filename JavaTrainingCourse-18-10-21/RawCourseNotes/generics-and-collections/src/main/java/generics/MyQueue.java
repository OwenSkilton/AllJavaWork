package generics;

// We make the class generic by adding the diamond operator after the class name
// The type parameter - E - will be replaced at instantiation time by a real type
public class MyQueue<E> {

    private int capacity;
    private Object[] elements;
    private int numElements;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.numElements = 0;
    }

    public void push(E element) throws Exception {
        if (numElements < capacity) {
            elements[numElements++] = element;
        } else {
            throw new Exception("The queue is full");
        }
    }

    public E pop() throws Exception {
        if (numElements > 0) {
            var elementToReturn = elements[0];
            for (var i = 1; i < numElements; i++) {
                elements[i - 1] = elements[i];
            }
            numElements -= 1;
            return (E) elementToReturn;
        } else {
            throw new Exception("The queue is empty");
        }
    }
}
