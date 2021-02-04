package com.oneby;

/**
 * @ClassName HelloGC
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 15:12
 * @Version 1.0
 */
public class HelloGC {

    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY：" + totalMemory / (double) 1024 / 1024 + "MB");
        System.out.println("MAX_MEMORY：" + maxMemory / (double) 1014 / 1024 + "MB");
    }

}
