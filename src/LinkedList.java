//Defining a LinkedList object
public class LinkedList {

    //Node definitions
    public class Node {
        int data;
        Node next;

        public Node(int add) {
            this.data = add;
            this.next = null;
        }
    }

    //Use the nodes we just defined
    public Node head;   //Shared head object in linked lists

    //Constructor
    public LinkedList() {
        head = null;
    }

    //Add node containing value at start (insert at head)
    public void addAtStart(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    //Return (just printing here) the node containing desired data
    public void find(int data) {
        Node current = head;
        boolean found = false;
        while (current.next != null) {
            if (data == current.data) {
                System.out.println("Found: " + data);
                found = true;

            }
            current = current.next;
        }
        if (!found)
            System.out.println("No value found");
    }

    public static void main(String[] args) {
        LinkedList abc = new LinkedList();
        abc.addAtStart(5);
        abc.addAtStart(10);
        abc.addAtStart(15);
        abc.addAtStart(20);

        abc.find(7);
        abc.find(20);
        abc.find(15);
        abc.find(1);


    }


}
