package com.zxw.iterator.v01;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 17:20
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        ArrayList_ al = new ArrayList_();

        for (int i = 0; i < 15; i++) al.add("s" + i);

        System.out.println(al.size());
    }
}

class ArrayList_ {
    Object[] objects = new Object[10];
    // 数组中下一个空位置的下标，或者说总共的元素个数
    private int index = 0;

    public void add(Object o) {
        if (index == objects.length) { // 数组装满了
            Object[] objs = new Object[index * 2]; // 新建一个数组扩展大小为原来的两倍
            System.arraycopy(objects, 0, objs, 0, objects.length);
            objects = objs;
        }

        objects[index] = o;
        index++;
    }

    public int size() {
        return index;
    }
}
