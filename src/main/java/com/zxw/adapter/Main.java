package com.zxw.adapter;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 18:00
 * @Version: 1.0
 * @Description: InputStreamReader 就是一个转换接口
 */
public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\zxw\\work\\linux命令备忘.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();

        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }

        br.close();
        isr.close();
        fis.close();
    }
}
