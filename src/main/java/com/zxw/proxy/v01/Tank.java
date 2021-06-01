package com.zxw.proxy.v01;

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
        System.out.println("Tank moving claclacla.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Movable {
    void move();
}
