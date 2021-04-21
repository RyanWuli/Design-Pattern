package com.zxw.strategy;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 10:21
 * @Version: 1.0
 * @Description: 定义比较接口（实现中每次都要强转不完美）
 */
public interface Comparable {

    int compareTo(Comparable comp);
}
