package com.zxw.strategy;

import java.util.Arrays;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 18:17
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {3,46,49,4,646,44,8,3,5,4,5,574,64,8,5656};
        Sorter.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----------------------");

        Cat[] arrC = { new Cat(5, 5), new Cat(3,3), new Cat(1, 1)};
        Sorter.sortCat(arrC);
        System.out.println(Arrays.toString(arrC));

        System.out.println("------------------------> 接口实现通用比较");
        Dog[] arrD = {new Dog(1), new Dog(5), new Dog(3)};
        Fish[] arrF = {new Fish(3), new Fish(5), new Fish(1)};
        Sorter.sortComp(arrD);
        Sorter.sortComp(arrF);
        System.out.println(Arrays.toString(arrD));
        System.out.println(Arrays.toString(arrF));

    }
}
