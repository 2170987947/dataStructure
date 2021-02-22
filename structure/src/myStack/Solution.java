package myStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/17 8:54
 */
public class Solution {
    public Deque<Integer> pushA;
    public Deque<Integer> popA;


    public void so(int[] pushA, int[] popA) {
        Deque<Integer> stack = new LinkedList<>();
        while (popA != null) {
            int temp = popA;
            if (stack == null || ) {

            } else {
                
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 5, 4, 2, 1};
        solution.so(arr1, arr2);
    }
}
