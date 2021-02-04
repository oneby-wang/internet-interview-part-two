package com.oneby;

/**
 * @ClassName UnableCreateNewThreadDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/10 12:59
 * @Version 1.0
 */
public class UnableCreateNewThreadDemo {

    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            System.out.println(i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}