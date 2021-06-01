package com.zxw.iterator.v02;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 17:32
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        LinkedList_ ll = new LinkedList_();

        for (int i = 0; i < 15; i++) ll.add("s" + i);

        System.out.println(ll.size());
    }
}

class LinkedList_ {

    Node head = null; // 记录链表的头
    Node tail = null; // 记录链表的尾 （只记录头就行，但是这样效率高些）

    private int size = 0; // 目前容器中共有多少个元素

    private class Node { // 链表的节点
        private Object o; // 真正的数据
        Node next;

        public Node(Object obj) {
            this.o = obj;
        }
    }

    public int size() {
        return size;
    }

    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if (head == null) { // 如果是第一个数据
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size++;
    }
}
