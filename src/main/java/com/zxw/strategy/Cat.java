package com.zxw.strategy;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 9:54
 * @Version: 1.0
 * @Description:
 */
public class Cat {

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat cat) {
        if (this.weight < cat.weight) return -1;
        else if (this.weight > cat.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cat{");
        sb.append("weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }
}
