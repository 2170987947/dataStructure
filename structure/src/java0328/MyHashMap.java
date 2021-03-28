package java0328;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/28 21:21
 */
public class MyHashMap {
    public MapNode[] arr = new MapNode[10];
    public int size = 0;

    public Integer put(int key, int value) {
        Integer result = null;
        int index = key % arr.length;
        for (MapNode cur = arr[index]; cur != null; cur = cur.next) {
            if (key == cur.key) {
                result = cur.value;
                cur.value = value;
            }
        }
        MapNode newNode = new MapNode(key, value);
        newNode.next = arr[index];
        arr[index] = newNode;
        return result;
    }

    public Integer get(int key) {

        return null;
    }
}
