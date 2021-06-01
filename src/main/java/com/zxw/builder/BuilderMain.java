package com.zxw.builder;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 16:59
 * @Version: 1.0
 * @Description:
 */
public class BuilderMain {

    public static void main(String[] args) {
        TerrainBuilder tb = new ComplexTerrainBuilder();
        Terrain t = tb.buildWall().buildFork().buildMine().build();
        System.out.println(t);
    }
}
