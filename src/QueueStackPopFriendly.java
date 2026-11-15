
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class QueueStackPopFriendly {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push operation - O(n)
    public void push(int value) {

        q2.add(value);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println(value + " pushed into Stack");
    }

    // Pop operation - O(1)
    public int pop() {

        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        return q1.remove();
    }

    // Check whether Stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Return Stack size
    public int size() {
        return q1.size();
    }

    // View top element
    public int peek() {

        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        return q1.peek();
    }

    public static void main(String[] args) {

        QueueStackPopFriendly stack =
                new QueueStackPopFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Stack size: " + stack.size());
    }
}
