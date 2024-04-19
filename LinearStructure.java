
package dsa;
public class LinearStructure {
	
	public static class LinearQueue {
	    private int front;
	    private int rear;
	    private int maxSize;
	    private int[] queueArray;

	    public LinearQueue(int size) {
	        maxSize = size;
	        queueArray = new int[maxSize];
	        front = -1;
	        rear = -1;
	    }

	    public void enqueue(int data) {
	        if (rear == maxSize - 1) {
	            System.out.println("Queue is full. Cannot enqueue " + data);
	        } else {
	            if (front == -1) {
	                front = 0;
	            }
	            rear++;
	            queueArray[rear] = data;
	            System.out.println("Enqueued: " + data);
	        }
	    }

	    public void dequeue() {
	        if (front == -1 || front > rear) {
	            System.out.println("Queue is empty. Cannot dequeue.");
	        } else {
	            int data = queueArray[front];
	            front++;
	            if (front > rear) {
	                front = rear = -1; // Reset front and rear when the queue becomes empty
	            }
	            System.out.println("Dequeued: " + data);
	        }
	    }

	    public void displayQueue() {
	        if (front == -1 || front > rear) {
	            System.out.println("Queue is empty.");
	        } else {
	            System.out.print("Queue: ");
	            for (int i = front; i <= rear; i++) {
	                System.out.print(queueArray[i] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        LinearQueue queue = new LinearQueue(5);
	        queue.displayQueue(); // Queue is empty.

	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	        queue.displayQueue(); // Queue: 10 20 30

	        queue.dequeue();
	        queue.displayQueue(); // Queue: 20 30

	        queue.enqueue(40);
	        queue.enqueue(50);
	        queue.displayQueue(); // Queue: 20 30 40 50

	        queue.enqueue(60); // Queue is full. Cannot enqueue 60
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue(); // Queue is empty. Cannot dequeue.
	        queue.displayQueue(); // Queue is empty.
	    }
	}
}
