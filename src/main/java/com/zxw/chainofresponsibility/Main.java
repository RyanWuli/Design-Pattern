package com.zxw.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/4/30 11:05
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好 :)，我是 vae <script>, 欢迎到 qq.music.com 收听我的独创歌曲摇头玩...");

        // 1
        // 处理 msg
//        String s = msg.getMsg();
//        s = s.replace("<", "[");
//        s = s.replace(">", "]");
//
//        s = s.replace("摇头玩", "xxx");
//        msg.setMsg(s);
//        System.out.println(msg);

        // 2
//        new HtmlFilter().doFilter(msg);
//        new SensitiveFilter().doFilter(msg);
//        System.out.println(msg);

        // 3
//        List<Filter> filters = new ArrayList<>();
//        filters.add(new HtmlFilter());
//        filters.add(new SensitiveFilter());
//
//        for (Filter f : filters) {
//            f.doFilter(msg);
//        }
//
//        System.out.println(msg);

        // 4
//        FilterChain fc = new FilterChain();
//        fc.addFilter(new HtmlFilter());
//        fc.addFilter(new SensitiveFilter());
//        fc.doFilter(msg);
//        System.out.println(msg);

        // 5
//        FilterChain fc = new FilterChain();
//        fc.addFilter(new HtmlFilter())
//                .addFilter(new SensitiveFilter()); // 编程小技巧，返回当前对象，就可以链式使用方法
//
//        fc.doFilter(msg);
//        System.out.println(msg);

        // 6
//        FilterChain fc = new FilterChain();
//        fc.addFilter(new HtmlFilter())
//                .addFilter(new SensitiveFilter()); // 编程小技巧，返回当前对象，就可以链式使用方法
//        FilterChain fc2 = new FilterChain();
//        fc2.addFilter(new FaceFilter()).addFilter(new UrlFilter());
//
//        fc.doFilter(msg);
//        fc2.doFilter(msg);
//        System.out.println(msg);

        // 7
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
    void doFilter(Msg msg);
}

class HtmlFilter implements Filter {

    @Override
    public void doFilter(Msg msg) {
        // 处理 msg
        String s = msg.getMsg();
        s = s.replace("<", "[");
        s = s.replace(">", "]");
        msg.setMsg(s);
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace("摇头玩", "xxx");
        msg.setMsg(s);
    }
}

class FaceFilter implements Filter {

    @Override
    public void doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace(":)", "(〃'▽'〃)");
        msg.setMsg(s);
    }
}

class UrlFilter implements Filter {

    @Override
    public void doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replace("qq.music.com", "https://www.qq.music.com");
        msg.setMsg(s);
    }
}



class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter f) {
        filters.add(f);
        return this;
    }

    public void doFilter(Msg msg) {
        for (Filter f : filters) {
            f.doFilter(msg);
        }
    }
}
