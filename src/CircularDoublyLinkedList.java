
public class CircularDoublyLinkedList {

    // Node class
    private static class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    // Insert at beginning
    public void insertAtBeginning(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            Node tail = head.previous;

            newNode.next = head;
            newNode.previous = tail;

            tail.next = newNode;
            head.previous = newNode;

            head = newNode;
        }

        size++;
    }

    // Insert at end
    public void insertAtEnd(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            Node tail = head.previous;

            newNode.next = head;
            newNode.previous = tail;

            tail.next = newNode;
            head.previous = newNode;
        }

        size++;
    }

    // Delete a node
    public boolean delete(int value) {

        if (head == null) {
            return false;
        }

        Node current = head;

        do {
            if (current.data == value) {

                if (size == 1) {
                    head = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;

                    if (current == head) {
                        head = current.next;
                    }
                }

                size--;
                return true;
            }

            current = current.next;

        } while (current != head);

        return false;
    }

    // Search for an element
    public boolean search(int value) {

        if (head == null) {
            return false;
        }

        Node current = head;

        do {
            if (current.data == value) {
                return true;
            }

            current = current.next;

        } while (current != head);

        return false;
    }

    // Display forward
    public void displayForward() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        System.out.print("Forward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.next;

        } while (current != head);

        System.out.println("(back to head)");
    }

    // Display backward
    public void displayBackward() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node tail = head.previous;
        Node current = tail;

        System.out.print("Backward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.previous;

        } while (current != tail);

        System.out.println("(back to tail)");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);

        System.out.println("Circular Doubly Linked List:");

        list.displayForward();
        list.displayBackward();

        System.out.println("Searching 20: " + list.search(20));

        System.out.println("Deleting 10: " + list.delete(10));

        System.out.println("After deletion:");
        list.displayForward();

        System.out.println("List size: " + list.size());
    }
}
