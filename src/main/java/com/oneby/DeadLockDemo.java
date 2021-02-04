package com.oneby;

import java.util.concurrent.TimeUnit;

/**
 * 死锁是指两个或者两个以上的进程在执行过程中，因抢夺资源而造成的一种互相等待的现象，
 * 若无外力干涉它们将都无法推进下去，如果系统资源充足，进程的资源请求都能够得到满足，
 * 死锁出现的可能性也就很低，否则就会因争夺有限的资源而陷入死锁。
 *
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 12:48
 * @Version 1.0
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();

        /*
         * windows下的java运行程序，也有类似ps的查看进程的命令，但是目前我们需要查看的只是java
         *
         * linux
         *          ps -ef|grep xxxx    ls -l查看当前进程的命令
         *
         * windows
         *          jps = java ps      jps -l
         *          jstack
         * */
    }
}

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run() {
        // 持有自己的锁
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockA + "\t尝试获得：" + lockB);
            // 睡眠一会儿，保证另一个线程能持有自己的锁
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 还希望得到别人的锁
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockB + "\t尝试获得：" + lockA);
            }
        }
    }
}