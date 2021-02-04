package com.oneby;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName KnapsackCompleteDemo
 * @Description TODO
 * @Author Heygo
 * @Date 2020/8/14 10:18
 * @Version 1.0
 */
public class KnapsackCompleteDemo {

    public static void main(String[] args) {
        int maxValue = knapsack(8, 4, new int[]{-1, 2, 3, 4, 5}, new int[]{-1, 3, 4, 5, 6});
        System.out.println(maxValue);
    }

    /**
     * 完全背包问题
     *
     * @param W   背包的重量
     * @param N   现有物品的数量
     * @param wt  物品的重量
     * @param val 物品的价值
     * @return 背包中物品的最大价值
     */
    public static int knapsack(int W, int N, int[] wt, int[] val) {

        // dp[w] 表示：对于前 i(数组下标) 个物品，当背包容量为 w 时，能放下的最大价值为 dp[w]
        int[] dp = new int[W + 1];

        // 从第一个物品开始，一个一个放入物品
        for (int i = 1; i <= N; i++) {
            // 背包重量逐渐增大，尝试放入物品
            for (int w = wt[i]; w <= W; w++) {
               /*
                由于使用了一维数组，第 i 个物品可以重复放入，所以使用了升序遍历
                w[t] <= w <= W ：如果背包装得下此物品，则尝试放入
                w < wt[i] ：如果背包装不下此物品，则沿用上次的最优解
             */
                dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[W];
    }


//    /**
//     * 完全背包问题
//     *
//     * @param W   背包的重量
//     * @param N   现有物品的数量
//     * @param wt  物品的重量
//     * @param val 物品的价值
//     * @return 背包中物品的最大价值
//     */
//    public static int knapsack(int W, int N, int[] wt, int[] val) {
//
//        // dp[i][w] 表示：对于前 i 个，当背包容量为 w 时，能放下的最大价值为 dp[i][w]
//        int[][] dp = new int[N + 1][W + 1];
//
//        // 从第一个物品开始，一个一个放入物品
//        for (int i = 1; i <= N; i++) {
//            // 背包重量逐渐增大，尝试放入物品
//            for (int w = 1; w <= W; w++) {
//                // dp[][] 数组中的 i 对应 wt[] 和 val[] 数组中的 i
//                if (w - wt[i] < 0) {
//                    // 当前背包容量装不下，只能选择不装入背包，选择上一次的最大价值作为这次的最大价值
//                    dp[i][w] = dp[i - 1][w];
//                } else {
//                    // 0-1 背包选择上次的最优解： dp[i - 1][w - wt[i]]，体现了一个物品只能放入一次
//                    // 完全背包选择这次的最优解：dp[i][w - wt[i]]，体现了一个物品可以放入多次
//                    dp[i][w] = Math.max(dp[i - 1][w], dp[i][w - wt[i]] + val[i]);
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
