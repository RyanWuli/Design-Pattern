package com.zxw.iterator.v05;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 17:57
 * @Version: 1.0
 * @Description:
 */
public interface Collection_<T> {
    void add(T o);
    int size();
    Iterator_<T> iterator();
}
