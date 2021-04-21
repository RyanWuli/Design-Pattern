package com.zxw.strategy.upgrade2;

import com.zxw.strategy.upgrade.Comparable;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 18:10
 * @Version: 1.0
 * @Description: 排序算法
 */
public class Sorter<T> {

    /**
     * 接口实现通用比较
     * @param arrT
     */
    public void sortComp(T[] arrT, Comparator<T> comparator) {
        for (int i = 0; i < arrT.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arrT.length; j++) {
                minPos = comparator.compare(arrT[j], arrT[minPos]) == -1 ? j : minPos;
            }
            swapComp(arrT, i, minPos);
        }
    }

    void swapComp(T[] arrCom, int i, int j) {
        T temp = arrCom[i];
        arrCom[i] = arrCom[j];
        arrCom[j] = temp;
    }
}
