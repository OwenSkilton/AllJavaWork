package LinkedList;

public class Node {

    public String data;
    public Node next;

    public Node(String data, Node next){ // Used to create a normal node
        this.data = data;
        this.next = next;
    }
    public Node(String data){ //Use for making the tail node as no next value
        this.data = data;
    }
}