package com.zxw.iterator.v04;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 17:58
 * @Version: 1.0
 * @Description:
 */
public class ArrayList_ implements Collection_ {

    Object[] objects = new Object[10];
    // 数组中下一个空位置的下标，或者说总共的元素个数
    private int index = 0;

    @Override
    public void add(Object o) {
        if (index == objects.length) { // 数组装满了
            Object[] objs = new Object[index * 2]; // 新建一个数组扩展大小为原来的两倍
            System.arraycopy(objects, 0, objs, 0, objects.length);
            objects = objs;
        }

        objects[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_ {

        int currentIndex = 0; // 准备遍历的 index

        @Override
        public boolean hasNext() {
            return currentIndex < index; // 需要遍历的 index 小于总数，则说明后面还有元素
        }

        @Override
        public Object next() {
            Object obj = objects[currentIndex]; // 取出遍历的元素
            currentIndex++; // 准备遍历的 index + 1
            return obj;
        }
    }
}
