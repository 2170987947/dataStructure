package ArrayList1;

import java.util.Arrays;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/28 22:10
 */
public class MyArrayList<E> {
    private E[] elem;
    private int size;
    private int capacity;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.elem = (E[]) new Object[this.capacity];
    }
    // 1. 增
    // a. 末尾新增
    public void add(E data) {
        if (this.capacity == this.size) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.capacity);
            this.capacity = this.elem.length;
        }
        this.elem[this.size] = data;
        this.size++;
    }
    // b. 插入
    public void insert(int index, E data) {
        // 插入位置不合法
        if (index < 0 || index > this.size) {
            System.out.println("插入异常");
            return;
        }
        // 扩容
        if (this.capacity == this.size) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.capacity);
            this.capacity = this.elem.length;
        }
        // 移动元素
        for (int i = this.size; i > index; i--) {
            this.elem[i] = this.elem[i - 1];
        }
        // 插入
        this.elem[index] = data;
        this.size++;
    }
    // 2.删
    // a. 通过下标删除顺序表对应的元素
    public void deleteIndex(int index) {
        for (int i = index; i < this.size; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.size--;
    }
    // b. 删除第一次出现的 key 关键字
    public void deleteKey(E key) {
        for (int i = 0; i < this.size; i++) {
            if (key == this.elem[i]) {
                this.elem[i] = this.elem[this.size - 1];
                this.size--;
                return;
            }
        }
    }
    // c. 删除在顺序表中出现的所有 key 关键字
    public void deleteAllKey(E key) {
        for (int i= 0; i < this.size; i++) {
            // 使用 while 是因为删除关键字 key 时, 是将最后一个元素放至要删除的位置
            // 将元素个数 -1, 所以需要对刚刚放至删除位置的元素也要进行判断.
            while (key == this.elem[i]) {
                this.elem[i] = this.elem[this.size - 1];
                this.size--;
            }
        }
    }
    // 3. 改
    public void update(int index, E date) {
        this.elem[index] = date;
    }
    // 4. 查
    // a. 通过下标查找,返回顺序表中对应的值
    public E findIndex(int index) {
        return this.elem[index];
    }
    // b. 通过关键字查找,返回下标
    public int findElem(E key) {
        for (int i = 0; i < this.size; i++) {
            if (key == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }
    // c. 查找是否包含 key 关键字
    public boolean contains(E key) {
        for (int i = 0; i < this.size; i++) {
            if (key == this.elem[i]) {
                return true;
            }
        }
        return false;
    }
    // 5. 清空
    public void clear() {
        this.size = 0;
    }
    // 6. 显示
    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    // 7. 求长度
    public int getLength() {
        return this.size;
    }
}
