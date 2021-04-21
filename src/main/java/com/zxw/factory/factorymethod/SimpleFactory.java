package com.zxw.factory.factorymethod;

/**
 * @Author: Ryan
 * @Date: 2021/4/21 10:41
 * @Version: 1.0
 * @Description: 简单工厂-扩展性不好
 */
public class SimpleFactory {

    public Car createCar() {
        // before processing，创建之前可以处理一些权限之类的
        return new Car();
    }

    public Plane createPlane() {
        return new Plane();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
