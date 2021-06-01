package com.zxw.bridge.v04;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 10:39
 * @Version: 1.0
 * @Description: 用聚合代替继承
 */
public class GG {

    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    public void give(MM mm, Gift gift) {

    }
}
