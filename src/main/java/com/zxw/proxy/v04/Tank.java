package com.zxw.proxy.v04;

import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 17:26
 * @Version: 1.0
 * @Description:
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
 * tank 的代理
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

interface Movable {
    void move();
}


