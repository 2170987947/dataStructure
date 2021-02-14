package myQueue;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/11 23:43
 */
public class StackTransformQueue {
    public Deque<Integer> stack1;
    public Deque<Integer> stack2;

    public void offer(Integer e) {
        this.stack2.push(e);
    }
    public Integer peek() {
        if (this.stack1 == null && this.stack2 == null) {
            return null;
        }
        if (this.stack2 != null && this.stack1 == null) {
            while (this.stack2 != null) {
                this.stack1.push(stack2.pop());
            }
        }
        return this.stack1.peek();
    }
    public Integer poll() {
        if (this.stack1 == null && this.stack2 == null) {
            return null;
        }
        if (this.stack1 == null && this.stack2 != null) {
            this.stack1.push(this.stack2.pop());
        }
        return this.stack1.pop();
    }

    public static void main(String[] args) {
       StackTransformQueue stackTransformQueue = new StackTransformQueue();
        stackTransformQueue.offer(1);
        stackTransformQueue.offer(2);
        stackTransformQueue.offer(3);
        stackTransformQueue.offer(4);

        System.out.println(stackTransformQueue.peek());
        System.out.println(stackTransformQueue.poll());

    }
}
