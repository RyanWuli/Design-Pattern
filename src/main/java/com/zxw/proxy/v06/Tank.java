package com.zxw.proxy.v06;

import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 17:26
 * @Version: 1.0
 * @Description: 静态代理 - 非常像装饰模式
 *               新问题：只能代理 movable 相关，能不能代理所有类 object，比如日志，所有的都可以有日志呀，不灵活
 *               答案就是动态代理 - v07
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
//        new TankProxy(new TankLogProxy(new Tank())).move(); // 想谁在外层（最开始执行或者最后执行）执行就放前面
        new TankLogProxy(new TankProxy(new Tank())).move();
    }

}

/**
 * tank 的代理（时间）
 */
class TankProxy implements Movable {

    Movable movable;

    public TankProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis(); // 记录方法执行起始时间

        movable.move();

        long end = System.currentTimeMillis(); // 记录方法执行完成时间

        System.out.println("Tank moved time is " + (end - start) + " ms");
    }
}

/**
 * tank 的日志代理
 */
class TankLogProxy implements Movable {

    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("Tank start moving.....");
        movable.move();
        System.out.println("Tank stop.....");
    }
}

interface Movable {
    void move();
}


