package com.zxw.builder;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 16:51
 * @Version: 1.0
 * @Description: 地形构建者
 */
public interface TerrainBuilder {

    TerrainBuilder buildWall();
    TerrainBuilder buildFork();
    TerrainBuilder buildMine();

    Terrain build();
}
