package com.zxw.proxy.v05;

import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 17:26
 * @Version: 1.0
 * @Description: 聚合 tank 到代理比直接 v03 继承 tank 好，因为如果多个功能同时实现，继承有很多种组合方式，比如先日志再时间或者闲时间再日志
 *               但是问题是这里只是聚合 tank 了，想两种代理都实现也不好弄，办法 v06
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段时间那
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank(); // 缺点 只代理了 tank 其他用不了
        TankProxy tankProxy = new TankProxy(tank);
        tankProxy.move();
    }

}

/**
 * tank 的代理（时间）
 */
class TankProxy implements Movable {

    Tank tank;

    public TankProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis(); // 记录方法执行起始时间

        tank.move();

        long end = System.currentTimeMillis(); // 记录方法执行完成时间

        System.out.println("Tank moved time is " + (end - start) + " ms");
    }
}

/**
 * tank 的日志代理
 */
class TankLogProxy implements Movable {

    Tank tank; // 聚合 tank 到代理比直接 v03 继承 tank 好，因为如果多个功能同时实现，继承有很多种组合方式，比如先日志再时间或者闲时间再日志

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("Tank start moving.....");
        tank.move();
        System.out.println("Tank stop.....");
    }
}

interface Movable {
    void move();
}


