package com.oneby;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GCOverheadDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 23:02
 * @Version 1.0
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("***************i:" + i);
            e.printStackTrace();
            throw e;
        }

    }
}
