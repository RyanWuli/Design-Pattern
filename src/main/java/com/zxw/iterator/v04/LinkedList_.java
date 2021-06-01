package com.zxw.iterator.v04;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 18:06
 * @Version: 1.0
 * @Description:
 */
public class LinkedList_ implements Collection_ {

    Node head = null; // 记录链表的头
    Node tail = null; // 记录链表的尾 （只记录头就行，但是这样效率高些）

    private int size = 0; // 目前容器中共有多少个元素

    private class Node { // 链表的节点
        private Object o; // 真正的数据
        Node next;

        public Node(Object obj) {
            this.o = obj;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Node{");
            sb.append("o=").append(o);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }


    @Override
    public void add(Object o) {
        Node n = new LinkedList_.Node(o);
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

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_ {

        Node n = head;

        @Override
        public boolean hasNext() {
            if (n != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            Object obj = n.o;
            n = n.next;
            return obj;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LinkedList_{");
        sb.append("head=").append(head);
        sb.append(", tail=").append(tail);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
