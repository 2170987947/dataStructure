package myQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/9 17:49
 */
public class KuoHaoPiPei {
    public static void main(String[] args) {
//        Deque<Integer> deque = new LinkedList<>();
//        deque.addFirst(1);
//        Queue queue = (Queue) new LinkedList();
//        deque.push(4);
        Deque<Character> stack = new LinkedList<>();
        String string = "[{}]()";
        String string1 = "{}{{})";
        System.out.println(pi(stack, string));
        System.out.println(pi(stack, string1));

    }
    public static boolean pi(Deque stack, String string) {
        char[] chars = string.toCharArray();
        for (char s: chars) {
            switch (s) {
                case '[':
                case '{':
                case  '(':
                    stack.push(s);
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!comp(s,stack.peek())) {
                        return false;
                    } else {
                        stack.pop();
                    }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean comp(char s, Object peek) {
        char c = (char) peek;
        if (c == '[' && s ==']') {
            return true;
        } else if (c == '{' && s == '}') {
            return true;
        } else if (c == '(' && s == ')') {
            return true;
        } else {
            return false;
        }
    }
}
