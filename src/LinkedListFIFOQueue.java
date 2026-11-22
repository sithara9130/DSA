
public class LinkedListFIFOQueue {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedListFIFOQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add an element to the queue
    public void enqueue(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove an element from the queue
    public int dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int removedValue = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return removedValue;
    }

    // View the front element
    public int peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return front.data;
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get queue size
    public int size() {
        return size;
    }

    // Display queue elements
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = front;

        System.out.print("Front -> ");

        while (current != null) {

            System.out.print(current.data + " -> ");

            current = current.next;
        }

        System.out.println("Rear");
    }

    public static void main(String[] args) {

        LinkedListFIFOQueue queue =
                new LinkedListFIFOQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue after adding elements:");

        queue.display();

        System.out.println("Front element: " + queue.peek());

        System.out.println("Removed element: " + queue.dequeue());

        System.out.println("Queue after dequeue:");

        queue.display();

        System.out.println("Queue size: " + queue.size());
    }
}
