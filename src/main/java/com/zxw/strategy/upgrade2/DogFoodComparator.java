package com.zxw.strategy.upgrade2;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 11:57
 * @Version: 1.0
 * @Description:
 */
public class DogFoodComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.getFood() < o2.getFood()) return -1;
        else if (o1.getFood() > o2.getFood()) return 1;
        else return 0;
    }
}
