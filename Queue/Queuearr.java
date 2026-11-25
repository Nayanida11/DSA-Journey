class Queue1 {

    int front = 0;
    int size = 0;
    int capacity = 10;

    // ENQUEUE
    void enqueue(int arr[], int data) {

        if (size == capacity) {

            System.out.println("Queue Overflow");
            return;
        }

        int pos = (front + size) % capacity;

        arr[pos] = data;

        size++;
    }

    // DEQUEUE
    int dequeue(int arr[]) {

        if (size == 0) {

            System.out.println("Queue Underflow");
            return -1;
        }

        int data = arr[front];

        front = (front + 1) % capacity;

        size--;

        return data;
    }

    // DISPLAY
    void display(int arr[]) {

        if (size == 0) {

            System.out.println("Queue is empty");
            return;
        }

        for (int i = 0; i < size; i++) {

            int pos = (front + i) % capacity;

            System.out.print(arr[pos] + " ");
        }

        System.out.println();
    }
}

public class Queuearr {

    public static void main(String[] args) {

        Queue1 q = new Queue1();

        int arr[] = new int[10];

        q.enqueue(arr, 10);
        q.enqueue(arr, 20);
        q.enqueue(arr, 30);

        System.out.println("Queue:");
        q.display(arr);

        System.out.println("Dequeued: " + q.dequeue(arr));

        System.out.println("Queue after dequeue:");
        q.display(arr);

        q.enqueue(arr, 40);
        q.enqueue(arr, 50);

        System.out.println("Queue after more enqueue:");
        q.display(arr);
    }
}
