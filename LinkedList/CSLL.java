```java
package LL;

public class CSLL {

    private Node head;
    private Node tail;
    private int size;

    // Node class inside CSLL
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

    // Getter for size
    public int getSize() {
        return size;
    }

    // Insert at first
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }

        size++;
    }

    // Insert at last
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
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
            tail.setNext(head);
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
            Node temp = head;

            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }

            tail = temp;
            tail.setNext(head);
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

        while (temp.getNext() != head &&
               temp.getNext().getData() != data) {
            temp = temp.getNext();
        }

        if (temp.getNext() == head) {
            System.out.println("Data not found");
            return;
        }

        if (temp.getNext() == tail) {
            tail = temp;
        }

        temp.setNext(temp.getNext().getNext());

        tail.setNext(head);

        size--;
    }

    // Reverse
    public void reverse() {

        if (head == null || head == tail) {
            return;
        }

        Node previous = tail;
        Node current = head;
        Node next;

        do {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        } while (current != head);

        tail = head;
        head = previous;

        tail.setNext(head);
    }

    // Display
    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        } while (temp != head);

        System.out.println("(HEAD)");
    }

    // Main
    public static void main(String[] args) {

        CSLL list = new CSLL();

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

        System.out.println("Size: " + list.getSize());
    }
}
```
