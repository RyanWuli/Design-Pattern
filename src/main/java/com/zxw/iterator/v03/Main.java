package com.zxw.iterator.v03;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 18:10
 * @Version: 1.0
 * @Description: 问题如何进行容器遍历呢，普通的 for i 循环不能实现通用了
 *               解决办法就是 各自的容器实现 迭代器接口
 */
public class Main {

    public static void main(String[] args) {
//        Collection_ list = new ArrayList_();
        Collection_ list = new LinkedList_();

        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }

        System.out.println(list.size());
    }
}
