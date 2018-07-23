package cn.diyai.daynamicprogramming;

/**
 * Created by xing on 5/2/17.
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，
 * 定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，
 * 求出将A串变为B串所需要的最少代价。

 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
 保证两串长度均小于等于300，且三种代价值均小于等于100。

 测试样例：
 "abc",3,"adc",3,5,3,100
 返回：8
 */
import java.util.*;

public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        // write code here
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        // 初始化行，表示插入
        for (int i = 0; i <= n; i++) {
            dp[i][0] = c1 * i;
        }
        // 初始化列，表示删除
        for (int j = 0; j <= m; j++) {
            dp[0][j] = c0 * j;
        }

        int min = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                min = Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c0);
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = Math.min(min, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(min, dp[i - 1][j - 1] + c2);
                }
            }
        }

        return dp[n][m];
    }
}
