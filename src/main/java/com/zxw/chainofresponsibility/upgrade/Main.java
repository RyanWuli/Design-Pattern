package com.zxw.chainofresponsibility.upgrade;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/4/30 11:05
 * @Version: 1.0
 * @Description: // 责任链
 */
public class Main {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好 :)，我是 vae <script>, 欢迎到 qq.music.com 收听我的独创歌曲摇头玩...");

        FilterChain fc = new FilterChain();
        fc.addFilter(new HtmlFilter())
                .addFilter(new SensitiveFilter()); // 编程小技巧，返回当前对象，就可以链式使用方法
        FilterChain fc2 = new FilterChain();
        fc2.addFilter(new FaceFilter()).addFilter(new UrlFilter());

        fc.addFilter(fc2);
        fc.doFilter(msg);
        System.out.println(msg);
    }
}

interface Filter {
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        // 处理 msg
        String s = msg.getMsg();
        s = s.replace("<", "[");
        s = s.replace(">", "]");
        msg.setMsg(s);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace("摇头玩", "xxx");
        msg.setMsg(s);
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace(":)", "(〃'▽'〃)");
        msg.setMsg(s);
        return true;
    }
}

class UrlFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace("qq.music.com", "https://www.qq.music.com");
        msg.setMsg(s);
        return true;
    }
}


class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter f) {
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg msg) {
        for (Filter f : filters) {
            if (!f.doFilter(msg)) return false;
        }
        return true;
    }
}
