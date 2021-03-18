package java0315_Heap;

import java.util.Arrays;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/15 19:21
 */
public class Test {
    public static void main(String[] args) {
        int[] arr1 = {49, 38, 65, 97, 76, 13, 27, 49};
        Heap heap = new Heap();
        System.out.println(Arrays.toString(heap.buildHeap(arr1, arr1.length)));
        heap.remove(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
//        heap.remove(arr1, arr1.length - 1);
//        System.out.println(Arrays.toString(arr1));
//        heap.insert(arr1, arr1.length - 2, 27);
//        System.out.println(Arrays.toString(arr1));

    }
}
