package dsa;

public class CircularQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] queueArray;

    public CircularQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data) {
        if ((front == 0 && rear == maxSize - 1) || (rear == (front - 1) % (maxSize - 1))) {
            System.out.println("Queue is full. Cannot enqueue " + data);
        } else if (front == -1) {
            front = rear = 0;
            queueArray[rear] = data;
            System.out.println("Enqueued: " + data);
        } else if (rear == maxSize - 1 && front != 0) {
            rear = 0;
            queueArray[rear] = data;
            System.out.println("Enqueued: " + data);
        } else {
            rear++;
            queueArray[rear] = data;
            System.out.println("Enqueued: " + data);
        }
    }

    public void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else if (front == rear) {
            int data = queueArray[front];
            front = rear = -1;
            System.out.println("Dequeued: " + data);
        } else if (front == maxSize - 1) {
            int data = queueArray[front];
            front = 0;
            System.out.println("Dequeued: " + data);
        } else {
            int data = queueArray[front];
            front++;
            System.out.println("Dequeued: " + data);
        }
    }

    public void displayQueue() {
        if (front == -1) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(queueArray[i] + " ");
                }
            } else {
                for (int i = front; i < maxSize; i++) {
                    System.out.print(queueArray[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(queueArray[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.displayQueue(); // Queue is empty.

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.displayQueue(); // Queue: 10 20 30

        queue.dequeue();
        queue.displayQueue(); // Queue: 20 30

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Queue is full. Cannot enqueue 60
        queue.displayQueue(); // Queue: 20 30 40 50

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Queue is empty. Cannot dequeue.
        queue.displayQueue(); // Queue is empty.
    }
}