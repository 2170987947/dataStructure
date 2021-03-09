package MyStackAndQueue;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/9 13:54
 */
public class MyStack2 {
    private int[] stack = new int[100];
    private int size;

    public void push(int e) {
        if (this.size == stack.length) {
            return;
        }
        this.stack[this.size++] = e;
    }
    public Integer peek() {
        if (this.size == 0) {
            return null;
        }
        return this.stack[this.size - 1];
    }
    public Integer pop() {
        if (this.size == 0) {
            return null;
        }
        int result = this.stack[this.size - 1];
        this.size--;
        return result;
    }
}
