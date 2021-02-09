package ArrayList;

import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;
    public MyArrayList() {
        this.elem = new int[5];
        this.usedSize = 0;
    }
    //
    //在 pos 位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("位置不合法");
            return;
        }
        if (this.usedSize == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        for (int i = this.usedSize; i > pos; i--) {
            this.elem[i] = this.elem[i - 1];
        }
        this.elem[pos] = data;
        this.usedSize++;
        }
    //判定是否包含某元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }
    //获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos < 0  || pos >= this.usedSize) {
            System.out.println("输入位置不合法");
        }
        return this.elem[pos];
    }
    //给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos >= this.usedSize) {
            System.out.println("输入位置不合法");
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字 key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if (index == -1) {
            System.out.println("该数字不存在");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }
    //获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    //打印顺序表
    public void display() {
        if (this.usedSize == 0) {
            System.out.println("顺序表为空");
            return;
        }
        System.out.print("顺序表为 : ");
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    //清空顺序表
    public void clear() {
//        for (int i = 0; i < this.usedSize; i++) {
//            this.elem[i] = null;
//        }
        this.usedSize = 0;
    }
}
