
import java.util.NoSuchElementException;
import java.util.Arrays;

public class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    private static final int INITIAL_CAPACITY = 2;

    // Constructor
    public UnboundedArrayStack() {
        capacity = INITIAL_CAPACITY;
        stack = new int[capacity];
        top = -1;
    }

    // Resize the array
    private void resize(int newCapacity) {

        stack = Arrays.copyOf(stack, newCapacity);
        capacity = newCapacity;

        System.out.println("Array resized to: " + capacity);
    }

    // Push operation
    public void push(int value) {

        if (top == capacity - 1) {
            resize(capacity * 2);
        }

        stack[++top] = value;

        System.out.println(value + " pushed into Stack");
    }

    // Pop operation
    public int pop() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        int removed = stack[top];
        stack[top] = 0;
        top--;

        // Shrink when usage reaches one-quarter
        if (capacity > INITIAL_CAPACITY &&
                size() <= capacity / 4) {

            resize(Math.max(INITIAL_CAPACITY, capacity / 2));
        }

        return removed;
    }

    // Peek operation
    public int peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        return stack[top];
    }

    // Check whether Stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Return number of elements
    public int size() {
        return top + 1;
    }

    // Return current array capacity
    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack =
                new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Current size: " + stack.size());
        System.out.println("Current capacity: " + stack.getCapacity());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Current size: " + stack.size());
        System.out.println("Current capacity: " + stack.getCapacity());
    }
}
