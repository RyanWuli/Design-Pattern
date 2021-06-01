package com.zxw.chainofresponsibility.servlet.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 15:02
 * @Version: 1.0
 * @Description: 模拟 request 和 response 用同一个 filter 但是 request 按照123顺序过滤，response 按照321顺序过滤
 *               只处理了 request
 *               加上新处理的 response, 但是 response 的顺序不对
 *               chain 里面不循环执行，改为记录位置执行，执行过程类似递归思想
 *               就是 servlet 的方案
 */
public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.req = "大家好 :)，我是 vae <script>, 欢迎到 qq.music.com 收听我的独创歌曲摇头玩...";
        Response response = new Response();

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());
        fc.doFilter(request, response, fc);

        System.out.println(request.req);
        System.out.println(response.res);
    }
}

interface Filter {
    boolean doFilter(Request req, Response res, FilterChain chain);
}

class Request {
    String req = "";
}

class Response {
    String res = "";
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request req, Response res, FilterChain chain) {
        req.req = req.req.replaceAll("<", "[").replaceAll(">", "]");
        chain.doFilter(req, res, chain);
        res.res += "HtmlFilter>>>>>";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request req, Response res, FilterChain chain) {
        req.req = req.req.replaceAll("摇头玩", "xxx");
        chain.doFilter(req, res, chain);
        res.res += "SensitiveFilter>>>>>";
        return true;
    }
}

class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request req, Response res, FilterChain chain) {
        if (index < filters.size()) {
            filters.get(index++).doFilter(req, res, chain);
            return true;
        }
        return false;
    }
}
