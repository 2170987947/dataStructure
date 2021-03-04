package LinkedList2.iml;

import java.util.NoSuchElementException;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/4 12:53
 */
public interface Deque extends Queue {
    // 这些方法通过特殊返回值报错
    public boolean offerFirst(Integer e);
    public Integer peekFirst();
    public Integer pollFirst();

    public boolean offerLast(Integer e);
    public Integer peekLast();
    public Integer pollLast();

    // 这组方法通过异常报错
    default void adddFirst(Integer e) {
        if (offerFirst(e) == false) {
            throw new IllegalStateException();
        }
    }
    default Integer getFirst() {
        Integer e = peekFirst();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer removeFirst() {
        Integer e = pollFirst();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
}
