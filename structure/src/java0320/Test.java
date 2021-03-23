package java0320;


import java.util.Set;
import java.util.TreeSet;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/20 11:45
 */
public class Test {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("apple");
        System.out.println(set.contains("apple"));
        System.out.println(set.add("banana"));
        System.out.println(set.size());
        System.out.println(set);
    }
}
