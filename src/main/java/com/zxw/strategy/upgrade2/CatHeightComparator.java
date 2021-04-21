package com.zxw.strategy.upgrade2;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 12:02
 * @Version: 1.0
 * @Description:
 */
public class CatHeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.height < o2.height) return -1;
        else if (o1.height > o2.height) return 1;
        else return 0;
    }
}
