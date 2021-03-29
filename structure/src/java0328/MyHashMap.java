package java0328;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/28 21:21
 */
public class MyHashMap {
    public HashNode[] arr = new HashNode[10];
    public int size = 0;

    // 如果没有此键值对，就返回 null
    // 如果有，则返回之前 value 的值，并且将之前 value 的值进行修改。
    public Integer put(int key, int value) {
        Integer result = null;
        // 找出该 key 的位置
        int index = key % arr.length;
        // 寻找 key 是否存在
        for (HashNode cur = arr[index]; cur != null; cur = cur.next) {
            // 存在，就修改 value
            if (key == cur.key) {
                result = cur.value;
                cur.value = value;
            }
        }
        // 不存在， 插入到链表头部
        HashNode newNode = new HashNode(key, value);
        newNode.next = arr[index];
        arr[index] = newNode;
        size++;

        // 冲突因子
        if (loadFactor() > 0.75) {
            // 扩容
            resize();
        }
        return result;
    }

    private void resize() {
        // 临时创建新数组
        HashNode[] newarr = new HashNode[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            // 用于记录下一个需要遍历的结点
            HashNode next = null;
            for (HashNode cur = arr[i]; cur != null; cur = next) {
                // 更新下一个节点的指向
                next = cur.next;
                // 寻找在新数组中的位置
                int index = cur.key % newarr.length;
                HashNode node = new HashNode(cur.key, cur.value);
                // 进行插入
                node.next = newarr[index];
                newarr[index] = node;
            }
        }
        // arr 指向临时数组，实现扩容
        arr = newarr;
    }

    // 负载因子： 元素个数 / 数组长度
    private double loadFactor() {
        return (double) size / arr.length;
    }

    // 根据 key 找 value，存在就返回 value，不存在返回 null
    public Integer get(int key) {
        int index = key % arr.length;
        for (HashNode cur = arr[index]; cur != null; cur = cur.next) {
            if (key == cur.key) {
                return cur.value;
            }
        }
        return null;
    }
    // 删除键值对，先找到 key, 进行删除，并返回 key 所对应的 value 值
    public Integer remove(int key) {
        Integer result = null;
        int index = key % arr.length;
        HashNode pre = null;
        for (HashNode cur = arr[index]; cur != null; cur = cur.next) {
            // 找到了 key
            if (cur.key == key) {
                result = cur.value;
                if (pre == null) {
                    // 删除头结点
                    arr[index] = arr[index].next;
                } else {
                    // 删除其他位置
                    pre.next = cur.next;
                }
            }
            pre = cur;
        }
        return result;
    }
}
