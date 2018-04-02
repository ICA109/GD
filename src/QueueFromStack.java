import java.util.Stack;

public class QueueFromStack {

    //Test driver method
    public static void main(String[] args) {
        QueueFromStack q1 = new QueueFromStack();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        //Expect 1, 2, 3
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());


    }

    //Queue requires 3 core features: a data element unit (implicit within Stack), an enqueue(), and an dequeue()
    //This approach assumes more frequent dequeue than enqueue operations
    Stack<Integer> internalStack = new Stack<>();
    private int numElements = 0;

    //Add new int element to end of queue (i.e. top of stack)
    private void enqueue(int element) {
        internalStack.push(element);
        numElements++;
    }

    //Remove and fetch value of newest element from queue
    private int dequeue() {
        int count = numElements;
        Stack<Integer> temp = new Stack<>();
        int currElem;

        if (count == 0) {
            return -1;  //Represents failed dequeue operation
        }

        while (count > 1) {
            currElem = internalStack.pop();
            temp.push(currElem);
            count--;
        }

        //Now count should be 1 (i.e. only first element at bottom of stack remains)
        currElem = internalStack.pop();

        //Load elements from temp stack back into original in right order
        while(!temp.empty()) {
            internalStack.push(temp.pop());
        }

        numElements--;
        return currElem;
    }

}
