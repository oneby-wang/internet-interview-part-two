package com.oneby;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @ClassName WeakHashMapDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/9 22:14
 * @Version 1.0
 */
public class WeakHashMapDemo {
    public static void main(String[] args){
        myHashMap();
        System.out.println("========");
        myWeakHashMap();
    }

    private static void myHashMap(){
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        // key 置为 null ，关 HashMap 毛事啊，HashMap 已经将数据保存至 Node 节点中了
        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap(){
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
