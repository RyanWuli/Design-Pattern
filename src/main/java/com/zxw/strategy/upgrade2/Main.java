package com.zxw.strategy.upgrade2;

import com.sun.org.apache.bcel.internal.util.BCELifier;

import java.util.Arrays;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 18:17
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        Cat[] cats = { new Cat(5, 5), new Cat(3,3), new Cat(1, 1)};
        Dog[] dogs = {new Dog(1), new Dog(5), new Dog(3)};
        Sorter<Dog> sorter = new Sorter<>();
        sorter.sortComp(dogs, new DogFoodComparator());
        System.out.println(Arrays.toString(dogs));

        Sorter<Cat> catSorter = new Sorter<>();
        catSorter.sortComp(cats, new CatHeightComparator());
        System.out.println(Arrays.toString(cats));

        catSorter.sortComp(cats, (o1, o2) -> { // 体重大排前面
            if (o1.weight > o2.weight) return -1;
            else if (o1.weight < o2.weight) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(cats));

    }
}
