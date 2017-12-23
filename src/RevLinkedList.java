public class RevLinkedList {
    public static void main(String[] args) {
        LinkedListT a = new LinkedListT();
        a.addAtBegin(5);
        a.addAtBegin(10);
        a.addAtBegin(15);
        a.addAtBegin(20);
        a.addAtBegin(25);
        a.addAtBegin(30);
        a.display(a.head);
        a.head = a.reverseIterative(a.head);
        System.out.println("Now");
        a.display(a.head);
    }
}


//First define a linked list
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
//Return the reverse linked list

class LinkedListT {
    public Node head;
    //public Node tail;

    public LinkedListT() {
        head = null;
    }

    public void addAtBegin(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    //Modified to return the desired node value
    public Node reverseIterative(Node head) {
        Node currNode = head;
        Node nextNode = null;
        Node prevNode = null;

        //  a -> b -> c
        while (currNode != null) {
            nextNode = currNode.next;   //b, c
            currNode.next = prevNode;   //null, a
            prevNode = currNode;        //a, b
            currNode = nextNode;        //b, c
        }
        head = prevNode;
        System.out.println("Reverse through iteration");
        display(head);
        return head;

    }

    public void display(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print("->" + currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println("\nDone");
    }

}

