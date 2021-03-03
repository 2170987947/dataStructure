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
    public static boolean isOrder(int[] pushStack, int[] popStack) {
        List<Integer> pushList = toList(pushStack);
        List<Integer> popList = toList(popStack);
        Deque<Integer> stack = new LinkedList<>();
        while (!popList.isEmpty()) {
            int p = popList.remove(0);
            while (true) {
                if (stack.isEmpty() || stack.peek().intValue() != p) {
                    if (pushList.isEmpty()) {
                        return false;
                    }
                    stack.push(pushList.remove(0));
                } else {
                    break;
                }
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 2, 1};
        System.out.println(isOrder(arr1, arr2));
    }
}
