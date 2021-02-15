package myQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/11 23:10
 */
public class QueueTransformStack {
    Deque<Integer> stack = new LinkedList<>();

    public void push(Integer e) {
        this.stack.offer(e);
    }
    public Integer peek() {
        for (int i = 0; i < this.stack.size() - 1; i++) {
            Integer e = this.stack.poll();
            this.stack.offer(e);
        }
        return this.stack.peek();
    }
    public Integer pop() {
        for (int i = 0; i < this.stack.size() - 1; i++) {
            Integer e = this.stack.poll();
            this.stack.offer(e);
        }
        return this.stack.poll();
    }

    public static void main(String[] args) {
        QueueTransformStack queueTransformStack = new QueueTransformStack();
//        queueTransformStack.stack.offer(1);
//        queueTransformStack.stack.offer(2);
//        queueTransformStack.stack.offer(3);
        queueTransformStack.push(1);
        queueTransformStack.push(2);
        queueTransformStack.push(3);

        queueTransformStack.push(4);
        System.out.println(queueTransformStack.pop());
        System.out.println(queueTransformStack.peek());
        System.out.println(queueTransformStack.pop());
        System.out.println(queueTransformStack.pop());
        System.out.println(queueTransformStack.pop());

//        System.out.println(queueTransformStack.stack.pop());
    }
}

