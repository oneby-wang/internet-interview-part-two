package com.oneby;

import java.util.Random;

/**
 * @ClassName JavaHeapSpaceDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 22:53
 * @Version 1.0
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args){
        String str = "seu";

        while(true){
            str += str + new Random().nextInt(11111111)+new Random().nextInt(22222222);
            str.intern();
        }

    }
}