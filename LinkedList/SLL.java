
import java.util.*;

public class SLL {

    private Node head;
    private int size;

    // Node class inside SLL
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Getter and Setter for data
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        // Getter and Setter for next
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Getter and Setter for head
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    // Getter and Setter for size
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Insert at first
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        newNode.setNext(head);
        head = newNode;

        size++;
    }

    // Insert at last
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(newNode);
        size++;
    }

    // Insert at position
    public void insertAtPosition(int data, int position) {

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertFirst(data);
            return;
        }

        if (position == size + 1) {
            insertLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.getNext();
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);

        size++;
    }

    // Delete at first
    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.getNext();
        size--;
    }

    // Delete at last
    public void deleteLast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.getNext() == null) {
            head = null;
            size--;
            return;
        }

        Node temp = head;

        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(null);
        size--;
    }

    // Delete at position
    public void deleteAtPosition(int position) {

        if (position < 1 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            deleteFirst();
            return;
        }

        if (position == size) {
            deleteLast();
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.getNext();
        }

        temp.setNext(temp.getNext().getNext());

        size--;
    }

    // Delete by data
    public void deleteByData(int data) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.getData() == data) {
            deleteFirst();
            return;
        }

        Node temp = head;

        while (temp.getNext() != null &&
               temp.getNext().getData() != data) {

            temp = temp.getNext();
        }

        if (temp.getNext() == null) {
            System.out.println("Data not found");
            return;
        }

        temp.setNext(temp.getNext().getNext());
        size--;
    }

    // Reverse
    public void reverse() {

        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {

            next = current.getNext();

            current.setNext(previous);

            previous = current;
            current = next;
        }

        head = previous;
    }

    // Display
    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }

        System.out.println("NULL");
    }

    // Main
    public static void main(String[] args) {

        SLL list = new SLL();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(30);
        list.insertLast(40);

        System.out.println("Original list:");
        list.display();

        list.insertAtPosition(25, 3);
        System.out.println("After inserting 25 at position 3:");
        list.display();

        list.deleteFirst();
        System.out.println("After deleting first:");
        list.display();

        list.deleteLast();
        System.out.println("After deleting last:");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("After deleting position 2:");
        list.display();

        list.insertLast(50);
        list.insertLast(60);

        System.out.println("Before deleting by data:");
        list.display();

        list.deleteByData(50);
        System.out.println("After deleting data 50:");
        list.display();

        list.reverse();
        System.out.println("After reverse:");
        list.display();
    }
}

