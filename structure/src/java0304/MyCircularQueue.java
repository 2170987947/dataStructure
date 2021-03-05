package java0304;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/4 18:51
 */
public class MyCircularQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        this.array = new int[k];
    }
    // 入队
    public boolean enQueue(int value) {
        if (size >= array.length) {
            return false;
        }
        array[rear] = value;
        if (rear + 1 == array.length) {
            rear = 0;
        } else {
            rear++;
        }
        size++;
        return true;
    }
    // 出队
    public boolean deQueue() {
        if (size <= 0) {
            return false;
        }
        if (front + 1 == array.length) {
            front = 0;
        } else {
            front++;
        }
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return array[front];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        if (rear - 1 == -1) {
            return array[array.length - 1];
        } else {
            return array[rear - 1];
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (size == array.length) {
            return true;
        }
        return false;
    }
}
