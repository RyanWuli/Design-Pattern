package com.zxw.factory.abstractfactory;

/**
 * @Author: Ryan
 * @Date: 2021/4/24 14:31
 * @Version: 1.0
 * @Description:
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    @Override
    Food createFood() {
        return new Bread();
    }
}
