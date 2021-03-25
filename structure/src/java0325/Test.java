package java0325;

import java.util.Arrays;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/25 12:42
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8, 3};
        Sort sort = new Sort();
        sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
