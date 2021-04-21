package com.zxw.factory.factorymethod;

/**
 * @Author: Ryan
 * @Date: 2021/4/21 9:54
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        /*
        没有将工具抽象出来，自己管自己
         */

        // 想开车
        Car car = new Car();
        car.go();

        // 想开飞机
        Plane plane = new Plane();
        plane.go();

        /*
        抽象出了移动工具类
         */
        Movable movable = new Broom(); // 想用什么工具就 new 什么
        movable.go();

        /*
        工厂方法，每个类对应自己的工厂
         */
        System.out.println("----------------> 工厂方法");
        Movable m = new CarFactory().create();
        m.go();
    }
}
