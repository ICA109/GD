import java.util.ArrayList;
import java.util.HashMap;

public class StackWMap {

    /*
    public static void main(String[] args) {
        StackWMap stack = new StackWMap();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.finalIndex);
        System.out.println(stack.max());
        stack.pop();
        System.out.println(stack.max());
        stack.pop();
        stack.pop();
        stack.pop();
    }

    private HashMap<Integer, Object> internalMap;
    private Object maxElement;
    private int index;

    private int finalIndex;
    //private int maxElement;
    private int maxElemIndex;
    private int prevMaxElement;
    private int prevMaxElementIndex;

    public StackWMap() {
        internalMap = new HashMap();
        maxElement = null;
        index = 0;
    }

    public void push(Object elem) {
        internalMap.put(index, elem);
        index++;





        internalList.add(val);
        finalIndex++;
        if (val >= maxElement) {
            prevMaxElement = maxElement;
            prevMaxElementIndex = maxElemIndex;
            maxElement = val;
            maxElemIndex = finalIndex;
        }
    }

    public Integer pop() {
        try {
            int top = internalList.remove(finalIndex);

            if (top == maxElement) {
                maxElement = prevMaxElement;
                maxElemIndex = finalIndex;
            }
            finalIndex--;
            return top;
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Error. Cannot pop from empty stack!");
        }
        return null;
    }

    public Integer max() {
        try {
            int max = internalList.get(maxElemIndex);
            return max;
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Error. No maximum found!");
        }
        return null;
    }

    */


}
