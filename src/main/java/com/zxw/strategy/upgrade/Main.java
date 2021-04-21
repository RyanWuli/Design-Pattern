package com.zxw.strategy.upgrade;

import com.zxw.strategy.Cat;

import java.util.Arrays;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 18:17
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("------------------------> 接口实现通用比较");
        Dog[] arrD = {new Dog(1), new Dog(5), new Dog(3)};
        Fish[] arrF = {new Fish(3), new Fish(5), new Fish(1)};
        Sorter.sortComp(arrD);
        Sorter.sortComp(arrF);
        System.out.println(Arrays.toString(arrD));
        System.out.println(Arrays.toString(arrF));

    }
}
