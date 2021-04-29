package com.zxw.factory.abstractfactory;

/**
 * @Author: Ryan
 * @Date: 2021/4/24 14:18
 * @Version: 1.0
 * @Description: 抽象工厂类
 */
public abstract class AbstractFactory {

    // 创建交通工具
    abstract Vehicle createVehicle();
    // 创建武器
    abstract Weapon createWeapon();
    // 创建食物
    abstract Food createFood();
}
