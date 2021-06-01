package com.zxw.iterator.v03;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 18:06
 * @Version: 1.0
 * @Description:
 */
public class LinkedList_ implements Collection_ {

    LinkedList_.Node head = null; // 记录链表的头
    LinkedList_.Node tail = null; // 记录链表的尾 （只记录头就行，但是这样效率高些）

    private int size = 0; // 目前容器中共有多少个元素

    private class Node { // 链表的节点
        private Object o; // 真正的数据
        LinkedList_.Node next;

        public Node(Object obj) {
            this.o = obj;
        }
    }


    @Override
    public void add(Object o) {
        LinkedList_.Node n = new LinkedList_.Node(o);
        n.next = null;

        if (head == null) { // 如果是第一个数据
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
