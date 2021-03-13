package java0313;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/13 9:34
 */
public class CirculationDoubleQueue {
    private int[] arr;
    // capacity 表示队列的容量
    private int capacity;
    // front 表示头部元素的下标
    private int front;
    // rear 表示尾部元素的下一个元素
    private int rear;

    // 1. 思路
    // !!! : 浪费一个空间用于判断元素的空和满的条件
    // 因此当要求存储的元素个数最多为 size 时, 所创建的空间要比它大 1.
    // 当 front == rear 时, 表示队列为空
    // 当 rear + 1 == front 时, 表示队列为满

    // 2. 精确到具体实现上的空与满判断
    // 因为该循环双端队列使用数组实现的, 考虑到数组下标可能越界
    // 因此将空与满的条件进行稍微的变化
    // 当 front == rear 时, 表示队列为空
    // 当 (rear + 1) % capacity == front 时, 表示队列为满

    // size 为队列实际只能存储的元素个数
    public CirculationDoubleQueue(int size) {
        this.capacity = size + 1;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = 0;
    }
    // 3. 头插
    // 因为 front 对应的下标就是头部的元素位置
    // 因此头插要先 -1 先找到插入之后 front 的位置,
    // 然后直接在 front 位置赋值.
    // -1 时需要注意可能越界, 因此将它可以写为
    // front = (front - 1 + capacity) % capacity;
    public boolean insertFront(int val) {
        // 队列已满
        if ((this.rear + 1) % capacity == 0) {
            return false;
        }
        front = (front - 1 + capacity) % capacity
        arr[front] = val;
        return true;
    }

    // 4. 尾插
    // 因为 rear 对应的下标为尾部元素的下一个位置
    // 因此尾插要先赋值, 再找 rear 的位置.
    // rear 的位置为为尾部元素的下一个元素, 因此 + 1
    // +1 时需要注意可能越界, 因此将它可以写为
    // rear = (rear + 1) % capacity;
    public boolean insertRear(int val) {
        // 队列已满
        if ((this.rear + 1 + capacity) % capacity == 0) {
            return false;
        }

        arr[rear] = val;
        rear = (rear + 1) % capacity;
        return true;
    }

    // 5. 头删
    // 因为插入时是 -1, 删除时就是 +1
    // 防止越界 front = (front + 1) % capacity;
    public boolean deleteFront() {
        // 队列为空
        if (this.front == this.rear) {
            return false;
        }

        front = (front + 1) % capacity;
        return true;
    }

    // 6. 尾删
    // 因为插入时是 +1, 删除时就是 -1.
    // 防止越界 rear = (rear - 1 + capacity) % capacity;
    public boolean deleteRear() {
        // 队列为空
        if (this.front == this.rear) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public Integer getFront() {
        // 队列为空
        if (this.front == this.rear) {
            return null;
        }

        return arr[front];
    }

    public Integer getRear() {
        // 队列为空
        if (this.front == this.rear) {
            return null;
        }

        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((this.rear + 1) % capacity == this.front) {
            return true;
        }

        return false;
    }
}
