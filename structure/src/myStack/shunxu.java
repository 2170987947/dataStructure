package myStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/17 8:54
 */
public class shunxu {
    public Deque<Integer> stack1;
    public Deque<Integer> stack2;

    public void initStack() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }
    public void q() {
        if (this.stack1 == null) {
            return;
        }

    }
    
}
