package com.zxw.strategy.upgrade;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 10:21
 * @Version: 1.0
 * @Description: 定义比较接口(升级版，但是并不完美，因为如果比较的策略方式变化了就得重新改代码)
 */
public interface Comparable<T> {

    int compareTo(T t);
}
