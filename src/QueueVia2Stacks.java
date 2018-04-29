import java.util.EmptyStackException;
import java.util.Stack;

public class QueueVia2Stacks {

    private Stack s1;
    private Stack s2;

    public QueueVia2Stacks() {
        this.s1 = new Stack();
        this.s2 = new Stack();
    }

    public void enqueue(Object toAdd) {
        s1.push(toAdd);
    }

    public Object dequeue() {
        Object first = null;

        //Load into stack 2 in reversed order
        while (!s1.empty()) {
            Object tmp = s1.pop();
            s2.push(tmp);
        }

        //Ends up being the final (i.e. first) element in s1
        try {
            first = s2.pop();
        }
        catch (EmptyStackException ex) {
            System.out.println("Error cannot dequeue from an empty queue!");
        }

        //Restore stack 1 minus the first element
        while(!s2.empty()) {
            Object tmp2 = s2.pop();
            s1.push(tmp2);
        }

        return first;
    }


    public static void main(String[] args) {
        QueueVia2Stacks queue = new QueueVia2Stacks();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //System.out.println(queue.dequeue());
        //System.out.println(queue.dequeue());
        //System.out.println(queue.dequeue());
    }
}
