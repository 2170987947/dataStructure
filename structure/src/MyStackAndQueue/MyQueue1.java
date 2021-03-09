package MyStackAndQueue;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/9 14:09
 */
public class MyQueue1 {
    private Node head = null;
    private Node tail = null;

    public boolean offer(int e) {
        Node node = new Node(e);
        if (this.head == null) {
            this.head = this.tail = node;
            return true;
        }
        this.tail.next = node;
        this.tail = this.tail.next;
        return true;
    }
    public Integer peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.val;
    }
    public Integer poll() {
        if (this.head == null) {
            return null;
        }
        int result = this.head.val;
        this.head = this.head.next;
        return result;
    }
}
