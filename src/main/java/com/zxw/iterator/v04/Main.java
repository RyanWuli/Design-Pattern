package com.zxw.iterator.v04;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 18:10
 * @Version: 1.0
 * @Description: 实现迭代器

 */
public class Main {

    public static void main(String[] args) {
//        Collection_ list = new ArrayList_();
        Collection_ list = new LinkedList_();

        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }

        System.out.println(list);

        System.out.println(list.size());

        Iterator_ iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
