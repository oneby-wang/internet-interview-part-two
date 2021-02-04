package com.oneby;

import java.sql.Array;
import java.util.Arrays;

/**
 * @ClassName MultiplePackDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/14 10:56
 * @Version 1.0
 */
public class MultiplePackDemo {

    public static void main(String[] args) {

        int maxValue = multiplePack(15, 3, new int[]{-1, 2, 3, 4}, new int[]{-1, 3, 4, 5}, new int[]{-1, 4, 3, 2});
        System.out.println(maxValue);

    }

    /**
     * 多重背包问题
     *
     * @param W     背包的重量
     * @param N     现有物品的数量
     * @param wt    物品的重量
     * @param val   物品的价值
     * @param count 物品的数量
     * @return 背包中物品的最大价值
     */
    public static int multiplePack(int W, int N, int[] wt, int[] val, int[] count) {

        // dp[w] 表示：对于前 i(数组下标) 个物品，当背包容量为 w 时，能放下的最大价值为 dp[w]
        int[] dp = new int[W + 1];

        // 从第一个物品开始，一个一个放入物品
        for (int i = 1; i <= N; i++) {

            // 如果 count[i] * wt[i] >= W，说明当前物品数量无限制，当做完全背包来做
            if (count[i] * wt[i] >= W) {

                // 完全背包的写法：升序（第 i 件物品可重复放入）
                for (int w = wt[i]; w <= W; w++) {
                    dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
                }

            } else {
                // 0-1 背包的写法：降序（第 i 次的最大价值依赖于第 i-1 次的最大价值）
                for (int w = W; w >= wt[i]; w--) {
                    // 尝试将第 i 件物品，一件一件放入背包
                    for (int c = 0; c <= count[i] && c * wt[i] <= w; c++) {
                        dp[w] = Math.max(dp[w], dp[w - c * wt[i]] + c * val[i]);
                    }
                }

            }

            System.out.println(Arrays.toString(dp));

        }

        return dp[W];
    }


//    /**
//     * 多重背包问题
//     *
//     * @param W     背包的重量
//     * @param N     现有物品的数量
//     * @param wt    物品的重量
//     * @param val   物品的价值
//     * @param count 物品的数量
//     * @return 背包中物品的最大价值
//     */
//    public static int multiplePack(int W, int N, int[] wt, int[] val, int[] count) {
//
//        // dp[i][w] 表示：对于前 i 个物品，当背包容量为 w 时，能放下的最大价值为 dp[i][w]
//        int[][] dp = new int[N + 1][W + 1];
//
//        // 从第一个物品开始，一个一个放入物品
//        for (int i = 1; i <= N; i++) {
//            // 背包重量逐渐增大，尝试放入物品
//            for (int w = 1; w <= W; w++) {
//                // 将第 i 件物品一件一件放入，直到放不下为止
//                for (int c = 0; c <= count[i] && c * wt[i] <= w; c++) {
//                    // 尝试将第 i 件物品一件一件放入背包，从中取出价值最大的方案
//                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - c * wt[i]] + c * val[i]);
//                }
//            }
//        }
//
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//
//        return dp[N][W];
//    }

}
