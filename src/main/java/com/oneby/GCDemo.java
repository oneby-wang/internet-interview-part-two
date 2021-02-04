package com.oneby;

import java.util.Random;

/**
 * @ClassName GCDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/10 18:40
 * @Version 1.0
 */
public class GCDemo {

    public static void main(String[] args) {
        System.out.println("GCDemo...");
        try {
            String str = "bjtu";
            while (true) {
                str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
                str.intern();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}