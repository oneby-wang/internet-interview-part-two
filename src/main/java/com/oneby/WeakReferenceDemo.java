package com.oneby;

import java.lang.ref.WeakReference;

/**
 * @ClassName WeakReferenceDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 22:09
 * @Version 1.0
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("...............");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
