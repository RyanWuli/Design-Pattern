package com.zxw.factory.abstractfactory;

/**
 * @Author: Ryan
 * @Date: 2021/4/24 14:32
 * @Version: 1.0
 * @Description:
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new Wand();
    }

    @Override
    Food createFood() {
        return new Mushroom();
    }
}
