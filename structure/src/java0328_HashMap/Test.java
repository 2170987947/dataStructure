package java0328_HashMap;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/28 22:47
 */
public class Test {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        System.out.println(myHashMap.put(1, 3));
        System.out.println(myHashMap.put(2, 2));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.remove(1));
        System.out.println(myHashMap.get(1));
    }
}
