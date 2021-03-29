package java0329_BinarySearchTree;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/29 8:30
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        System.out.println(binarySearchTree.get(1));
        System.out.println(binarySearchTree.put(1, 3));
        System.out.println(binarySearchTree.put(3, 5));
        System.out.println(binarySearchTree.get(1));
        System.out.println(binarySearchTree.get(3));
        System.out.println(binarySearchTree.remove(1));
        System.out.println(binarySearchTree.remove(3));

    }
}
