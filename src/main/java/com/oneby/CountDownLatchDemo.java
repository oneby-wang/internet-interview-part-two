package com.oneby;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/8 17:43
 * @Version 1.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        county();
    }

    private static void county() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6); // 初始化次数为 6
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国被灭");
                countDownLatch.countDown(); // 计数器减 1
            }, CountryEnum.list(i).getRetMsg()).start();
        }
        countDownLatch.await(); // 等待上述线程执行完成（等待计数减为 0）
        System.out.println(Thread.currentThread().getName() + "\t ******秦国一统华夏");
    }

    private static void leaveClassroom() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6); // 初始化次数为 6
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");
                countDownLatch.countDown(); // 计数器减 1
            }, String.valueOf(i)).start();
        }
        countDownLatch.await(); // 等待上述线程执行完成（等待计数减为 0）
        System.out.println(Thread.currentThread().getName() + "\t ******班长最后关门走人");
    }
}
