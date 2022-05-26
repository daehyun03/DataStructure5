package daeHwan;

public class Queue<E>{
    private E[] arr;
    private int front;
    private int rear;


    public Queue(int size) {
        arr = (E[])new Object[size];
        front = 0;
        rear = 0;
    }

    public int size() {
        return rear - front;
    }

    public void enqueue(E newData) {
        arr[rear++ % arr.length] = newData;
    }

    public E dequeue() {
        E element = peek();
        front++;

        return element;
    }

    public E peek() {
        return arr[front % arr.length];
    }
}
