package java0326;

import java.util.Arrays;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/26 15:12
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {9, 3, 2, 1, 4, 6, 3};
        Sort sort = new Sort();
        sort.mergeSort(arr);
        System.out.println("归并排序: " + Arrays.toString(arr));
    }
}
