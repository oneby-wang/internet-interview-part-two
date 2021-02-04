package com.oneby;

import java.lang.ref.SoftReference;

/**
 * 内存够用的时候就保留，不够用就回收
 *
 * @ClassName SoftReferenceDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 21:54
 * @Version 1.0
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        //softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }

    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc(); // 进行 GC
        System.out.println(o1); // 强引用变量为 null 必被回收
        System.out.println(softReference.get()); // 内存够用不会回收软引用对象
    }

    /*
        JVm配置，故意产生大对象并配置小的内存，让内存不够用，导致OOM，看软引用的回收情况
        -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

}
