import java.util.ArrayList;

public class Stack {

    //Driver method for testing
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("--------------------------------");
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());

        System.out.println("--------------------------------");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());

        System.out.println("--------------------------------");
        stack.pop();
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());

        System.out.println("--------------------------------");
        stack.pop();
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());

        //Remove last element
        System.out.println("--------------------------------");
        stack.pop();
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());

        //Try removing beyond last element
        System.out.println("--------------------------------");
        stack.pop();
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());

        //Add more elements back in
        System.out.println("--------------------------------");
        stack.push(10);
        stack.push(11);
        stack.push(7);
        stack.pop();
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());
    }

    /*
        Start of actual Stack object code
    */


    //Node wrapper for each object to hold a reference to the previous maximum value object
    class Node {
        private Integer value;
        private Node refToPrevMax;  //Point back to previous max if overshadowing it

        Node(Integer value, Node refToPrevMax) {
            this.value = value;
            this.refToPrevMax = refToPrevMax;
        }
    }

    private ArrayList<Node> internalList;
    private int finalIndex;
    private Integer maxValue;
    private Node refToMaxNode;

    Stack() {
        internalList = new ArrayList<>();
        finalIndex = -1;        //Keep track of internalList length; Starts at -1 so 1st element is at index 0
        maxValue = null;
        refToMaxNode = null;    //Object reference doesn't exist at first
    }

    //Push object to top of stack
    void push(Integer val) {
        Node newNode;
        if (maxValue == null || val >= maxValue) {
            newNode = new Node(val, refToMaxNode);
            internalList.add(newNode);
            refToMaxNode = newNode;
            maxValue = val;
        }
        else {
            newNode = new Node(val, null);
            internalList.add(newNode);
        }
        finalIndex++;
    }

    //Pop object from top of stack
    Integer pop() {
        try {
            Node top = internalList.remove(finalIndex);

            if (top.value.equals(maxValue)) {

                refToMaxNode = top.refToPrevMax;

                //Don't execute if this must be the 1 and only element remaining if no previous elements (the very first)
                if (refToMaxNode != null) {
                    maxValue = refToMaxNode.value;
                }
                else {
                    maxValue = null;
                }
            }
            finalIndex--;
            return top.value;
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Error. Cannot pop from empty stack!");
            return null;
        }
    }

    //Return value of maximum object from stack
    Integer max() {
        return maxValue;
    }

    //Helper methods
    int getFinalIndex() {
        return finalIndex;
    }
}
