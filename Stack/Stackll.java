import java.util.*;

class Stack1 {

    private Node top;

    // Node inside Stack
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

    // PUSH
    void push(int data) {

        Node newNode = new Node(data);

        newNode.setNext(top);
        top = newNode;
    }

    // POP
    int pop() {

        if (top == null) {

            System.out.println("Stack Underflow");
            return -1;
        }

        int data = top.getData();

        top = top.getNext();

        return data;
    }

    // PEEK
    int peek() {

        if (top == null) {

            System.out.println("Stack is empty");
            return -1;
        }

        return top.getData();
    }

    // DISPLAY
    void display() {

        if (top == null) {

            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;

        while (temp != null) {

            System.out.print(temp.getData() + " ");

            temp = temp.getNext();
        }

        System.out.println();
    }
}

public class Stackll {

    public static void main(String[] args) {

        Stack1 s = new Stack1();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Stack:");
        s.display();

        System.out.println("Peek: " + s.peek());

        System.out.println("Popped: " + s.pop());

        System.out.println("Stack after pop:");
        s.display();

        System.out.println("Peek: " + s.peek());
    }
}
