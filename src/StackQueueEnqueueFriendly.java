
import java.util.Stack;
import java.util.NoSuchElementException;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue operation - O(1)
    public void enqueue(int value) {

        s1.push(value);

        System.out.println(value + " added to Queue");
    }

    // Dequeue operation - O(n) worst case
    public int dequeue() {

        if (s1.isEmpty() && s2.isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }

        // Transfer elements only when s2 is empty
        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    // Peek operation
    public int peek() {

        if (s1.isEmpty() && s2.isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }

        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    // Check whether Queue is empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Return Queue size
    public int size() {
        return s1.size() + s2.size();
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
                new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(40);

        System.out.println("Removed: " + queue.dequeue());

        System.out.println("Queue size: " + queue.size());
    }
}
