package collections.generics;

public class MyQueue <E> {

    private int capacity;
    private Object[] elements;
    private int numElements;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.numElements = 0;
    }

    public void push(E element) throws Exception{
        if (numElements < capacity){ //If we've reached capacity within the array
            elements[numElements++] = element;
        } else {
            throw new Exception("The queue is full");
        }
    }

    public E pop() throws Exception {
        if (numElements > 0){
            var elementToReturn = elements[0];
            for (var i = 1; i < numElements; i++){
                elements[i-1] = elements[i];
            }
            numElements--;
            return (E) elementToReturn;
        } else {
            throw new Exception("Queue is empty");
        }
    }
}
