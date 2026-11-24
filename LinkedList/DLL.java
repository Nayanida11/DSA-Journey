import java.util.*;

public class DLL {

    private Node head;
    private Node tail;
    private int size;

    // Node class inside DLL
    private class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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

        // Getter and Setter for prev
        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    // Getters and Setters

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Insert at first
    public void insertFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        size++;
    }

    // Insert at last
    public void insertLast(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

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
        newNode.setPrev(temp);

        temp.getNext().setPrev(newNode);
        temp.setNext(newNode);

        size++;
    }

    // Delete at first
    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }

        size--;
    }

    // Delete at last
    public void deleteLast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }

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

        for (int i = 1; i < position; i++) {
            temp = temp.getNext();
        }

        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());

        size--;
    }

    // Delete by data
    public void deleteByData(int data) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null && temp.getData() != data) {
            temp = temp.getNext();
        }

        if (temp == null) {
            System.out.println("Data not found");
            return;
        }

        if (temp == head) {
            deleteFirst();
            return;
        }

        if (temp == tail) {
            deleteLast();
            return;
        }

        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());

        size--;
    }

    // Reverse
    public void reverse() {

        Node current = head;
        Node temp;

        while (current != null) {

            temp = current.getNext();

            current.setNext(current.getPrev());
            current.setPrev(temp);

            current = temp;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    // Display forward
    public void displayForward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getData() + " <-> ");
            temp = temp.getNext();
        }

        System.out.println("NULL");
    }

    // Display backward
    public void displayBackward() {

        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.getData() + " <-> ");
            temp = temp.getPrev();
        }

        System.out.println("NULL");
    }

    // Main
    public static void main(String[] args) {

        DLL list = new DLL();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(30);
        list.insertLast(40);

        System.out.println("Original list:");
        list.displayForward();

        list.insertAtPosition(25, 3);
        System.out.println("After inserting 25 at position 3:");
        list.displayForward();

        list.deleteFirst();
        System.out.println("After deleting first:");
        list.displayForward();

        list.deleteLast();
        System.out.println("After deleting last:");
        list.displayForward();

        list.deleteAtPosition(2);
        System.out.println("After deleting position 2:");
        list.displayForward();

        list.insertLast(50);
        list.insertLast(60);

        System.out.println("Before deleting by data:");
        list.displayForward();

        list.deleteByData(50);
        System.out.println("After deleting data 50:");
        list.displayForward();

        list.reverse();
        System.out.println("After reverse:");
        list.displayForward();

        System.out.println("Backward display:");
        list.displayBackward();
    }
}
 
