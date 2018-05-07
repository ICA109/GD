package CTCI;

import java.util.HashSet;

public class Q2_1_RmDuplicates {

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        delDup(head);
        System.out.println(head.printForward());
    }

    //Removes duplicates from a double linked list
    public static void delDup(LinkedListNode aNode) {
        HashSet<Integer> allElem = new HashSet<>();
        LinkedListNode prev = null;
        while (aNode != null) {
            if (allElem.contains(aNode.data)) {
                prev.next = aNode.next;     //Previous node now directly connects to successor
                //aNode.prev = prev;
            }
            else {
                allElem.add(aNode.data);
                aNode.prev = prev;        //Update previous pointer in case of prior update
                prev = aNode;
            }
            aNode = aNode.next;
        }

    }




}
