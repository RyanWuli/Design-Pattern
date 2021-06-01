package com.zxw.iterator.v03;

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
}
