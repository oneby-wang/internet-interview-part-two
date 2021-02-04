package com.oneby;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JosephuDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/12 20:05
 * @Version 1.0
 */
public class JosephuDemo {

    public static void main(String[] args) {
        josephu(7, 3, 3);
    }

    /**
     * 链表解决约瑟夫问题
     *
     * @param personCount 总人数
     * @param startNumber 从第 startNumber 个人开始数（索引从 1 开始）
     * @param number      每次数 number 个人，然后让此人蹲下
     */
    public static void josephu(int personCount, int startNumber, int number) {

        // 小可爱们组成的队列
        Queue<Integer> cutes = new LinkedList<>();

        // 将小可爱们放入队列中
        for (int i = startNumber; i <= personCount; i++) {
            cutes.add(i);
        }
        for (int i = 1; i < startNumber; i++) {
            cutes.add(i);
        }

        // 记录本次轮询了多少人
        int cycleCount = 0;

        // 有一个小可爱蹲下，则队列少一个人
        while (cutes.isEmpty() == false) {

            // 将队头的小可爱出队
            Integer cute = cutes.remove();

            // 如果轮询次数等于 number，让这个小可爱出队
            if(++cycleCount == number){
                System.out.println(cute);
                cycleCount = 0;
            }else{
                // 否则将小可爱加到队尾
                cutes.add(cute);
            }
        }
    }


//    /**
//     * 数组解决约瑟夫问题
//     *
//     * @param personCount 总人数
//     * @param startNumber 从第 startNumber 个人开始数（索引从 1 开始）
//     * @param number      每次数 number 个人，然后让此人蹲下
//     */
//    public static void josephu(int personCount, int startNumber, int number) {
//        // 把人放到数组中
//        int[] persons = new int[personCount];
//        for (int i = 1; i <= personCount; i++) {
//            persons[i] = i;
//        }
//
//        // 当前正在遍历哪个人？（指针）
//        int curIndex = startNumber - 1;
//        // 蹲下的人数
//        int downCount = 0;
//        // 当前轮询过的人数
//        int cycleCount = 0;
//
//        // 全部人蹲下之后，才能结束
//        while (downCount < personCount) {
//
//            // 如果此人已经蹲下了，则跳过
//            if (persons[curIndex % persons.length] == 0) {
//                curIndex++;
//            } else {
//                // 否则此人没有蹲下，cycleCount++ 表示轮训次数加 1
//                cycleCount++;
//
//                // 如果已经数了 number 次，则需要蹲下
//                if (cycleCount == number) {
//                    // 将此人编号输出后，让此人蹲下
//                    System.out.println(persons[curIndex % persons.length]);
//                    persons[curIndex % persons.length] = 0;
//                    // 轮询计数器置零
//                    cycleCount = 0;
//                    // 蹲下人数加 1
//                    downCount++;
//                }
//
//                // 遍历下一个人
//                curIndex++;
//            }
//
//        }
//
//    }
}
