package com.zxw.builder;

import com.zxw.factory.abstractfactory.Wand;
import org.springframework.core.style.ToStringCreator;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 16:42
 * @Version: 1.0
 * @Description: 地形类
 */
public class Terrain {
    Wall w;
    Fork f;
    Mine m;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Terrain{");
        sb.append("w=").append(w);
        sb.append(", f=").append(f);
        sb.append(", m=").append(m);
        sb.append('}');
        return sb.toString();
    }
}

/**
 * 墙
 */
class Wall {
    int x, y, w, h;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Wall{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", w=").append(w);
        sb.append(", h=").append(h);
        sb.append('}');
        return sb.toString();
    }
}

/**
 * 暗堡
 */
class Fork {
    int x, y, w, h;

    public Fork(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Fork{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", w=").append(w);
        sb.append(", h=").append(h);
        sb.append('}');
        return sb.toString();
    }
}

/**
 * 地雷
 */
class Mine {
    int x, y, w, h;

    public Mine(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Mine{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", w=").append(w);
        sb.append(", h=").append(h);
        sb.append('}');
        return sb.toString();
    }
}
