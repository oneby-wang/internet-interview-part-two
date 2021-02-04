package com.oneby;

/**
 * @ClassName StackOverflowErrorDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 22:48
 * @Version 1.0
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args){
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}