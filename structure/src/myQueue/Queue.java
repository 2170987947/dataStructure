package myQueue;

import java.util.NoSuchElementException;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/8 22:03
 */
public interface Queue {

    // 添加元素
    boolean offer(Integer e);
    default boolean add(Integer e) {
        // 没有元素, 删除失败
        if (offer(e) == false) {
            throw new IllegalStateException();
        }
        return true;
    }
    // 看队首元素, 但不删除
    Integer peek();
    default Integer element() {
        Integer e = peek();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    // 删除元素
    Integer pool();
    default Integer remove() {
        Integer e = pool();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
}
