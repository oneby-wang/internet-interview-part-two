package com.oneby;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CallableDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/8 21:51
 * @Version 1.0
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start(); // 开始执行耗时计算
        new Thread(futureTask, "BB").start(); // 开始执行耗时计算
        int result01 = 100;
        while (!futureTask.isDone()){
            // Do something here
        }
        // 要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成
        int result02 = futureTask.get();
        System.out.println("result=" + (result01 + result02));
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable come in ...");
        // 模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){

        }
        return 1024;
    }
}