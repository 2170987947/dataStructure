package myStack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/17 8:54
 */
public class Solution {
    // 重要程度排序:
    private List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    public boolean isPoOrder(int[] pushA, int[] popA) {
        List<Integer> pushList = intArrayToList(pushA);
        List<Integer> popList = intArrayToList(popA);
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
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 2, 1};
        System.out.println(solution.isPoOrder(arr1, arr2));

    }
}
