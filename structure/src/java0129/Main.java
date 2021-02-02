package java0129;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/29 12:36
 */
public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0,2);
        arrayList.toArray();
        System.out.println(arrayList.get(0));
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
