package java0130;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/30 17:19
 */
public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("mm");
        System.out.println(linkedList.add("f"));
        linkedList.add(1,"mm");
        linkedList.set(0,"kk");
//        System.out.println(linkedList.remove());
//        System.out.println(linkedList.remove());
        System.out.println(Arrays.toString(linkedList.toArray()));
    }

}
