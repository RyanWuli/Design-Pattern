package com.zxw.iterator.v05;

/**
 * @Author: Ryan
 * @Date: 2021/5/11 9:47
 * @Version: 1.0
 * @Description: 迭代器接口
 */
public interface Iterator_<T> {

    boolean hasNext();

    T next();
}
