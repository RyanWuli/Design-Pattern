package com.zxw.builder;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 16:54
 * @Version: 1.0
 * @Description:
 */
public class ComplexTerrainBuilder implements TerrainBuilder {

    Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder buildWall() {
        terrain.w = new Wall(10, 20, 32, 50);
        return this;
    }

    @Override
    public TerrainBuilder buildFork() {
        terrain.f = new Fork(15, 22, 35, 45);
        return this;
    }

    @Override
    public TerrainBuilder buildMine() {
        terrain.m = new Mine(20, 22, 32, 42);
        return this;
    }

    @Override
    public Terrain build() {
        return terrain;
    }
}
