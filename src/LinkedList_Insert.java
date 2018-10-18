public class LinkedList_Insert {
    /*
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode currentNodePointer = head;
        SinglyLinkedListNode leftNode = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        int pointerIndex = 0;

        // get to proper position (so left node is just ahead of insert)
        for (int i=0; i<position; i++) {
            leftNode = currentNodePointer;
            currentNodePointer = currentNodePointer.next;
        }

        leftNode.next = newNode;
        newNode.next = currentNodePointer;

        if (position == 0) {
            head = newNode;
        }
        return head;

    }
    */
}
