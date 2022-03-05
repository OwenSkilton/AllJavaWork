package LinkedList;

public class LLists {
    Node head;
    Node tail;
    Node listItemNode;

    // LList constructor
    public LLists(){
        head = new Node(null, null);
        tail = head;
        System.out.println("LList constructor");
    }

    // Create new nodes
    public void add(String value){
        System.out.println("LList add");
        if (tail == head){ // For an empty list
            System.out.println("LList tail == head Empty List at this point");
            head.data = value; // Define head data
            tail = new Node(null);
            head.next = tail; // Where the head node now points to
        } else if (tail.data == null){ // No data at tail
            System.out.println("LList has a head but empty tail data");
            tail.data = value;
            tail.next = null;
        } else {
            System.out.println("LList tail != head List has in place Head and Tail data values");
            listItemNode = new Node(value, null);
            tail.next = listItemNode;
            tail = listItemNode;
        }
    }

    public void insert(int insertPosition, Node newNode){
        Node p = head; // A node to start at to begin working through
        int i =0; // Counter initialise
        while(p.next != null && i < insertPosition -1){ // While the list isnt at the end and below the insertion point
            p = p.next; // Node to iterate through becomes the next node in the list
            i++;
        }
        newNode.next = p.next; //Once at the insertion point, the newNode then points to the one after the insertion point keeping the list intact.
        p.next = newNode;// Rewrite the node before the inserted one to point to the new node.
    }

    public void delete(int removePosition){
        Node p = head;
        int i =0;
        // Move the node to the previous node position that is to be deleted
        while(p.next != null && 1< removePosition -1){
            p =p.next;
            i++;
        }
        Node temp = p.next;
        p.next =p.next.next;
        temp.next = null;
    }

    public void print(){
        System.out.println("LList Print List");
        Node p = head;
        System.out.print("Head->");
        while (p != null){
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println("Tail.");
    }

    public static void main(String[] args){
        LLists linkedlist = new LLists();

        linkedlist.add("Carmarthen");
        linkedlist.add("Llanelli");
        linkedlist.add("Swansea");
        linkedlist.add("Neath");
        linkedlist.add("Port Talbort");
        linkedlist.add("Bridgend");
        linkedlist.add("Cardiff");
        linkedlist.print();
    }
}


