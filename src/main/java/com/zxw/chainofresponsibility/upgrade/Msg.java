package com.zxw.chainofresponsibility.upgrade;

/**
 * @Author: Ryan
 * @Date: 2021/4/30 11:07
 * @Version: 1.0
 * @Description:
 */
public class Msg {

    private String name;
    private String msg;

    public Msg() {
    }

    public Msg(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Msg{");
        sb.append("name='").append(name).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
