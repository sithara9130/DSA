
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class QueueStackPushFriendly {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push operation - O(1)
    public void push(int value) {
        q1.add(value);
        System.out.println(value + " pushed into Stack");
    }

    // Pop operation - O(n)
    public int pop() {

        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int removed = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return removed;
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

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.remove();
        q2.add(top);

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public static void main(String[] args) {

        QueueStackPushFriendly stack =
                new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Stack size: " + stack.size());
    }
}
