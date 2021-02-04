package com.oneby;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CASDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/7 15:43
 * @Version 1.0
 */
public class CASDemo {
    public static void main(String[] args) {
        /*
         CAS是什么？ ==>compareAndSet 比较并交换
        */
        AtomicInteger atomicInteger = new AtomicInteger(5);
        // 期望值与上次相同，修改成功
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data : " + atomicInteger.get());
        // 期望值与上次不同，修改失败
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data : " + atomicInteger.get());
    }
}
