package com.oneby;

/**
 * 模Metaspace空间溢出，我们不断生成类往元空间灌，类占据的空间总是会超过Metaspace指定的空间大小的
 *
 * @ClassName MetaspaceOOMTest
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/10 13:28
 * @Version 1.0
 */
public class MetaspaceOOMTest {

    static class OOMTest {

    }

    public static void main(String[] args) {
        int i = 0;//模拟多少次后发生异常

        try {
            while (true) {
                i++;
            }
        } catch (Throwable e) {
            System.out.println("********多少次后发生了异常：" + i);
            e.printStackTrace();
        }
    }

}
