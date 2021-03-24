package java0322;

import java.util.*;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/22 9:54
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {9, 3, 6, 2, 1, 5, 3};
        Sort sort = new Sort();
        sort.quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
//        Set<Integer> set = new TreeSet<>();
//        System.out.println(set.add(1));
//        System.out.println(set.add(2));
//        System.out.println(set.add(4));
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(4);
//        arrayList.add(3);
//        System.out.println(set.containsAll(arrayList));
//        System.out.println(set.addAll(arrayList));
//        System.out.println(set);
//        Map<Integer, String> map = new TreeMap<>();
//        System.out.println(map.get(1));
//        System.out.println(map.put(1, "mao"));
//        System.out.println(map.put(2, "jia"));
//        System.out.println(map);
//        System.out.println(map.get(2));
//        System.out.println(map.put(1, "jing"));
//        System.out.println(map);
    }
}

