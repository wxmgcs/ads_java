package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i]
 * assigned (0 indexed).
 Once you pay the cost, you can either climb one or two steps.
 You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

 Example 1:
 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

 Example 2:
 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

 Note:
 cost will have a length in the range [2, 1000].
 Every cost[i] will be an integer in the range [0, 999].

 */
public class MinCostClimbingStairs {

    //todo
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 16];
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    //优化后
    public int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] res = new int[cost.length];
        res[cost.length - 1] = cost[cost.length - 1];
        res[cost.length - 2] = cost[cost.length - 2];
        for(int i = cost.length - 3; i >= 0; i--) {
            res[i] = cost[i] + Math.min(res[i + 1], res[i + 2]);
        }
        return Math.min(res[0], res[1]);
    }

    @Test
    public void test(){
        Assert.assertEquals(15,minCostClimbingStairs(new int[]{10, 15, 20}));
        Assert.assertEquals(6,minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        Assert.assertEquals(15,minCostClimbingStairs2(new int[]{10, 15, 20}));
        Assert.assertEquals(6,minCostClimbingStairs2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
