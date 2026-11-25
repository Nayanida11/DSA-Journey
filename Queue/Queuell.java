class Queue {

    private Node front;

    // Node inside Queue
    private class Node {

        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        int getData() {
            return data;
        }

        void setData(int data) {
            this.data = data;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }

    // ENQUEUE
    void enqueue(int data) {

        Node newNode = new Node(data);

        if (front == null) {

            front = newNode;
            return;
        }

        Node temp = front;

        while (temp.getNext() != null) {

            temp = temp.getNext();
        }

        temp.setNext(newNode);
    }

    // DEQUEUE
    int dequeue() {

        if (front == null) {

            System.out.println("Queue Underflow");
            return -1;
        }

        int data = front.getData();

        front = front.getNext();

        return data;
    }

    // DISPLAY
    void display() {

        if (front == null) {

            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;

        while (temp != null) {

            System.out.print(temp.getData() + " ");

            temp = temp.getNext();
        }

        System.out.println();
    }
}

public class Queuell {

    public static void main(String[] args) {

        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Queue:");
        q.display();

        System.out.println("Dequeued: " + q.dequeue());

        System.out.println("Queue after dequeue:");
        q.display();

        q.enqueue(40);

        System.out.println("Queue after enqueue:");
        q.display();
    }
}

