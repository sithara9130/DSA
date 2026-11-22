
public class LinkedListStack {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    // Push an element onto the stack
    public void push(int value) {

        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        size++;
    }

    // Pop an element from the stack
    public int pop() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        int removedValue = top.data;

        top = top.next;

        size--;

        return removedValue;
    }

    // View the top element
    public int peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return top.data;
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get stack size
    public int size() {
        return size;
    }

    // Display stack elements
    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = top;

        System.out.println("Stack elements:");

        while (current != null) {

            System.out.println(current.data);

            current = current.next;
        }
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushing elements:");

        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Removed element: " + stack.pop());

        System.out.println("Stack after popping:");

        stack.display();

        System.out.println("Stack size: " + stack.size());
    }
}
