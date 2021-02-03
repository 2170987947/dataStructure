package ArrayList1;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/28 22:10
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myLinkedList = new MyArrayList<>(2);
        // 增
        System.out.print("新增: ");
//        myLinkedList.add(0,"1");
        myLinkedList.add("fee");
        myLinkedList.add(1,"2");
//        myLinkedList.add(2,"ee");
//        myLinkedList.add(3,"1");
//        myLinkedList.display();
        // 删
//        System.out.print("删除: ");
//        myLinkedList.deleteAllKey("1");
//        myLinkedList.deleteKey("1");
//        myLinkedList.deleteIndex(1);
        myLinkedList.display();
        // 查
//        System.out.print("查找: ");
//        System.out.println(myLinkedList.findElem("ee"));
//        System.out.println(myLinkedList.findIndex(1));
        // 改
//        System.out.print("修改: ");
//        myLinkedList.update(0,"fmm");
//         显示线性表所有信息
//        myLinkedList.display();
    }
}
