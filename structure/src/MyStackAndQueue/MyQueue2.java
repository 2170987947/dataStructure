package MyStackAndQueue;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/9 14:15
 */
public class MyQueue2 {
    private int[] queue = new int[10];
    private int head = 0;
    private int tail = 0;
    private int size;

    public boolean offer(int e) {
        if (this.size >= queue.length) {
            return false;
        }
        if (this.tail + 1 == this.queue.length) {
            this.tail = 0;
        } else {
            this.queue[tail++] = e;
        }
        this.size++;
        return true;
    }
    public Integer peek() {
        if (this.size <= 0) {
            return null;
        }
        return this.queue[this.head];
    }
    public Integer poll() {
        if (this.size <= 0) {
            return null;
        }
        int result = this.queue[this.head];

        if (this.head + 1 == this.queue.length) {
            this.head = 0;
        } else {
            this.head++;
        }
        this.size--;
        return result;
    }
}
