package myStack;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/10 22:40
 */
import java.util.*;
class MinStack {
    Deque<Integer> stack = null;
    Deque<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }
        int min = minStack.peek();
        if (min > x) {
            min = x;
        }
        minStack.push(min);

    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }
}
