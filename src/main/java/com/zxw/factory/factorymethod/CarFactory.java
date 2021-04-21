package com.zxw.factory.factorymethod;

/**
 * @Author: Ryan
 * @Date: 2021/4/21 11:20
 * @Version: 1.0
 * @Description: 工厂模式-工厂方法 ，各个实体类对应自己的工厂
 */
public class CarFactory {

    public Car create() {
        System.out.println("Creating new car.....");
        return new Car();
    }
}
