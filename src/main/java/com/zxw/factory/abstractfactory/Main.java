package com.zxw.factory.abstractfactory;

import com.zxw.factory.factorymethod.CarFactory;
import com.zxw.factory.factorymethod.Movable;
import com.zxw.factory.factorymethod.Plane;

/**
 * @Author: Ryan
 * @Date: 2021/4/21 9:54
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        /*
        没有工厂的时候
         */
        System.out.println("-------------------> 人类-开车，用 ak47 攻击，吃面包");
        // 人类-开车，用 ak47 攻击，吃面包
        Car car = new Car();
        car.go();
        AK47 ak47 = new AK47();
        ak47.attack();
        Bread bread = new Bread();
        bread.eatFood();

        System.out.println("-------------------> 巫婆-骑扫帚，用魔法杖攻击，吃毒蘑菇");
        // 巫婆-骑扫帚，用魔法杖攻击，吃毒蘑菇
        Broom broom = new Broom();
        broom.go();
        Wand wand = new Wand();
        wand.attack();
        Mushroom mushroom = new Mushroom();
        mushroom.eatFood();

        System.out.println("-----------------------> 抽象工厂模式");
//        AbstractFactory af = new ModernFactory(); // 如果想实现魔法世界则，修改工厂为魔法工厂即可
        AbstractFactory af = new MagicFactory();
        Vehicle vehicle = af.createVehicle();
        vehicle.go();
        Weapon weapon = af.createWeapon();
        weapon.attack();
        Food food = af.createFood();
        food.eatFood();

    }
}
