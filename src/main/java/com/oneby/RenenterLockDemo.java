package com.oneby;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName com.Heygo.RenenterLockDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/8 13:03
 * @Version 1.0
 */

/*
 * 可重入锁（也就是递归锁）
 *
 * 指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
 *
 * 也就是说，线程可以进入任何一个它已经拥有的锁所有同步着的代码块。
 *
 * t1	 invoked sendSMS()      t1线程在外层方法获取锁的时候
 * t1	 invoked sendEmail()    t1在进入内层方法会自动获取锁
 * t2	 invoked sendSMS()
 * t2	 invoked sendEmail()
 *
 */
public class RenenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

}

class Phone implements Runnable {
    //Reentrant TEST
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "set()");
        } finally {
            lock.unlock();
        }
    }
}
