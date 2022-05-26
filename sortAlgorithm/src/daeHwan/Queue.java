package daeHwan;

import java.util.NoSuchElementException;

public class Queue<E>{
    private E[] arr;
    private int front;
    private int rear;


    public Queue() {
        arr = (E[])new Object[4];
        front = 0;
        rear = 0;
    }

    public int size() {
        return rear - front;
    }



    public boolean isEmpty() {
        return front == rear;
    }


    public void enqueue(E newData) {
        if (rear - front >= arr.length) {
            resize(arr.length * 2);
        }

        arr[rear++ % arr.length] = newData;
    }

    public E dequeue() {
        E element = peek();
        front++;

        if (rear - front <= arr.length / 4 && arr.length > 4) {
            resize(arr.length / 2);
        }

        return element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return arr[front % arr.length];
    }



    public void resize(int newArrSize) {
        E[] newArr = (E[])new Object[newArrSize];
        int size = rear - front;

        for (int i = 0 ; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        }

        rear = size;
        front = 0;

        arr = newArr;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = rear - front;

        for (int i = 0 ; i < size; i++) {
             sb.append(arr[(front + i) % arr.length].toString());
             sb.append(' ');
        }

        return sb.toString();
    }
}
