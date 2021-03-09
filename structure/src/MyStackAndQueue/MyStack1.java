package MyStackAndQueue;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/9 13:46
 */
public class MyStack1 {
    private Node head = null;

    public void push(int e) {
        Node node = new Node(e);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    public Integer peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.val;
    }
    public Integer pop() {
        if (this.head == null) {
            return null;
        }
        Integer result = this.head.val;
        this.head = this.head.next;
        return result;
    }
}
