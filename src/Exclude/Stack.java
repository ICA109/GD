import java.util.ArrayList;

public class Stack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        System.out.println("--------------------------------");
        System.out.println("Final index: " + stack.finalIndex);
        System.out.println("Max: " + stack.max());



        stack.pop();
        System.out.println("--------------------------------");
        System.out.println("Final index: " + stack.finalIndex);
        System.out.println("Max: " + stack.max());



        stack.pop();
        System.out.println("--------------------------------");
        System.out.println("Final index: " + stack.finalIndex);
        System.out.println("Max: " + stack.max());

        stack.pop();
        System.out.println("--------------------------------");
        System.out.println("Final index: " + stack.finalIndex);
        System.out.println("Max: " + stack.max());


        //Remove last element
        stack.pop();
        System.out.println("--------------------------------");
        System.out.println("Final index: " + stack.finalIndex);
        System.out.println("Max: " + stack.maxValue);


        //Try removing beyond last element
        stack.pop();
        System.out.println("--------------------------------");
        System.out.println("Final index: " + stack.finalIndex);
        System.out.println("Max: " + stack.maxValue);


        /*
        System.out.println(stack.finalIndex);
        System.out.println(stack.max());
        stack.pop();
        System.out.println(stack.max());
        stack.pop();
        stack.pop();
        stack.pop();
        */
    }

    class Node {
        private Integer value;
        private Node refToPrevMax;  //Point back to previous max if your replacing it

        public Node(Integer value, Node refToPrevMax) {
            this.value = value;
            this.refToPrevMax = refToPrevMax;
        }
    }

    private ArrayList<Node> internalList;
    private int finalIndex;
    private Integer maxElement;
    private int maxElemIndex;

    private Integer maxValue;
    private Node refToMaxNode;

    public Stack() {
        internalList = new ArrayList<>();
        finalIndex = -1;     //Needs to be -1 so 1st element is at index 0
        maxValue = null;
        refToMaxNode = null;   //Object reference doesn't exist at first
        maxElemIndex = -1;   //There is no max initially
    }

    public void push(Integer val) {
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

    public Integer pop() {
        try {
            Node top = internalList.remove(finalIndex);

            if (top.value == maxValue) {

                refToMaxNode = top.refToPrevMax;

                //Don't execute if this must be the 1 and only element remaining if no previous elements (the very first)
                if (refToMaxNode != null) {
                    maxValue = refToMaxNode.value;
                }
                else {
                    maxValue = null;
                }

                //maxElement = prevMaxElement;
                //maxElemIndex = finalIndex;

            }
            finalIndex--;
            return top.value;
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Error. Cannot pop from empty stack!");
            return null;
        }
    }

    public Integer max() {
        return maxValue;
    }
}
