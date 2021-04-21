package com.zxw.strategy.upgrade2;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 11:42
 * @Version: 1.0
 * @Description: 可以通过增加比较器实现来 应对不同的比较业务
 *               策略模式：不同的类型实现某个接口（比如比较）的方式不同，可以用策略模式，策略一般是针对动作也就是方法而言的
 */
public interface Comparator<T> {

    int compare(T o1, T o2);
}
