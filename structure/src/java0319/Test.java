package java0319;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/19 12:46
 */
public class Test {
    public static void main(String[] args) {
        String s = "AB##C##";
        TreeTest treeTest = new TreeTest();
        System.out.println(treeTest.buildTreeUsePre(s));
    }
}
