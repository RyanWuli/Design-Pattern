package com.zxw.strategy.upgrade;

import com.zxw.strategy.Cat;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 18:10
 * @Version: 1.0
 * @Description: 排序算法
 */
public class Sorter {

    /**
     * 接口实现通用比较
     * @param arrCom
     */
    public static void sortComp(Comparable[] arrCom) {
        for (int i = 0; i < arrCom.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arrCom.length; j++) {
                minPos = arrCom[j].compareTo(arrCom[minPos]) == -1 ? j : minPos;
            }
            swapComp(arrCom, i, minPos);
        }
    }

    static void swapComp(Comparable[] arrCom, int i, int j) {
        Comparable temp = arrCom[i];
        arrCom[i] = arrCom[j];
        arrCom[j] = temp;
    }
}
