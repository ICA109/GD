public class Stack_Test {

    private static StackCustom stack;

    //Driver method for testing Stack.java
    public static void main(String[] args) {
        stack = new StackCustom();

        System.out.println("--------------------------------");
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        printHelper();

        System.out.println("Popped: " + stack.pop());
        printHelper();

        stack.pop();
        printHelper();

        stack.pop();
        printHelper();

        //Remove last element
        stack.pop();
        printHelper();

        //Try removing beyond last element
        stack.pop();
        printHelper();

        //Add more elements back in
        stack.push(10);
        stack.push(11);
        stack.push(7);
        stack.pop();
        printHelper();
    }

    private static void printHelper() {
        System.out.println("Final index: " + stack.getFinalIndex());
        System.out.println("Max: " + stack.max());
        System.out.println("--------------------------------");
    }

}
