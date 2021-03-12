import javafx.beans.binding.StringBinding;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/12 19:28
 */
public class java0312 {
    public boolean backspaceCompare(String S, String T) {
        // 记录退格后的字符串
        Deque<Character> s = new LinkedList<>();
        Deque<Character> t = new LinkedList<>();

        if (S != null) {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != '#') {
                    s.push(S.charAt(i));
                } else {
                    if (!s.isEmpty()) {
                        s.pop();
                    }
                }
            }
        }
        if (T != null) {
            for (int i = 0; i < T.length(); i++) {
                if (T.charAt(i) != '#') {
                    t.push(T.charAt(i));
                } else {
                    if (!t.isEmpty()) {
                        t.pop();
                    }
                }
            }
        }

        while (!s.isEmpty() && !t.isEmpty()) {
            if (s.pop() != t.pop()) {
                return false;
            }
        }
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        java0312 java0312 = new java0312();
        System.out.println(java0312.backspaceCompare("adc#c", "add#c"));
    }
}
