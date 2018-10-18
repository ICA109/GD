public class ReverseDoubleLinkedList {
    /*
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode currentNode = head;
        DoublyLinkedListNode previousNode = null;
        DoublyLinkedListNode futureNode = null;

        while(currentNode.next != null) {
            futureNode = currentNode.next;



            currentNode.next = previousNode;
            currentNode.prev = futureNode;

            previousNode = currentNode;
            currentNode = futureNode;
        }

        //final node
        currentNode.next = previousNode;
        currentNode.prev = null;
        head = currentNode;

        return head;
    }
    */
}
