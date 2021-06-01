package com.zxw.proxy.v02;

import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 17:07
 * @Version: 1.0
 * @Description: 问题-》想记录移动的时间
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段时间那
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis(); // 记录方法执行起始时间
        System.out.println("Tank moving claclacla.....");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis(); // 记录方法执行完成时间

        System.out.println("Tank moved time is " + (end - start) + " ms");
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Movable {
    void move();
}
