package java0303;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/3 23:06
 */
public class Sequence {
    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    public static boolean idOrder(int[] pushStack, int[] popStack) {
        List<Integer> pushS = toList(pushStack);
        List<Integer> popS = toList(popStack);
        Deque<Integer> stack = new LinkedList<>();
        while (popS != null) {
            int p = popS.remove(0);
            while (stack.isEmpty() || stack.peek().intValue() != p) {
                if (pushS == null) {
                    return false;
                }
                stack.push(pushS.remove(0));
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 2, 4, 1};
        System.out.println(idOrder(arr1, arr2));
    }
}
