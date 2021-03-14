package java0314;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Arrays;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/14 10:58
 */
public class Test {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode('1');
//        root.left = new TreeNode('2');
//        root.right = new TreeNode('3');
//        root.left.left = new TreeNode('4');
//        root.left.right = new TreeNode('E');
//        root.left.right.right = new TreeNode('F');
//        TreeTest treeTest = new TreeTest();
//        System.out.println(treeTest.createStringUseTree(root));
        int[] arr = {3, 4, 2, 7, 1};
        int[] arr1 = {7, 9, 10, 5, 1, 6, 4, 8, 0, 12, 11, 2, 3, 3};
        int[] arr2 = {3, 1, 3};
        Sort sort = new Sort();
//        System.out.println(Arrays.toString(sort.bubbleSort(arr)));
//        System.out.println(Arrays.toString(sort.insertSort(arr)));
//        System.out.println(Arrays.toString(sort.selectSort(arr)));
//        System.out.println(Arrays.toString(sort.hillSort(arr, arr.length / 2)));
//        System.out.println(Arrays.toString(sort.heapSort(arr)));
//        System.out.println(Arrays.toString(sort.heapSort(arr1)));
//        sort.fastSort(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
        sort.fastSort(arr1, 0, arr1.length);
        System.out.println(Arrays.toString(arr1));
    }
}
