
package dsa;

import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public T dequeue() {
        if (stack1.isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int size() {
        return stack1.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Is the queue empty? " + queue.isEmpty());
        System.out.println("Size of the queue: " + queue.size());
    }
}




