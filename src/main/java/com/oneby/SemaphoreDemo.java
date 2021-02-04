package com.oneby;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/8 19:02
 * @Version 1.0
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 模拟3个车位
        for (int i = 1; i <= 6; i++) { // 模拟6部车
            new Thread(() -> {
                try {
                    semaphore.acquire(); // 尝试抢车位（获取信号量）
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // 释放车位（释放信号量）
                }
            }, String.valueOf(i)).start();
        }
    }
}
