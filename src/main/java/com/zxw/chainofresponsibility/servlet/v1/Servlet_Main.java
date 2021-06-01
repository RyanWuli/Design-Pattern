package com.zxw.chainofresponsibility.servlet.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 15:02
 * @Version: 1.0
 * @Description: 模拟 request 和 response 用同一个 filter 但是 request 按照123顺序过滤，response 按照321顺序过滤
 *               只处理了 request
 *
 */
public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.req = "大家好 :)，我是 vae <script>, 欢迎到 qq.music.com 收听我的独创歌曲摇头玩...";
        Response response = new Response();

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());
        fc.doFilter(request, response);

        System.out.println(request.req);
    }
}

interface Filter {
    boolean doFilter(Request req, Response res);
}

class Request {
    String req;
}

class Response {
    String res;
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request req, Response res) {
        req.req = req.req.replaceAll("<", "[").replaceAll(">", "]");
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request req, Response res) {
        req.req = req.req.replaceAll("摇头玩", "xxx");
        return true;
    }
}

class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request req, Response res) {
        for (Filter filter : filters) {
            filter.doFilter(req, res);
        }
        return true;
    }
}
