package com.zxw.strategy;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 18:10
 * @Version: 1.0
 * @Description: 排序算法
 */
public class Sorter {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortCat(Cat[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            swapCat(arr, i, minPos);
        }
    }

    static void swapCat(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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
