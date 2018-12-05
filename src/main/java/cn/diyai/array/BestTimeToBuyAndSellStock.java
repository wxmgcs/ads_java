package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 Note that you cannot sell a stock before you buy one.

 Example 1:
 Input: [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Not 7-1 = 6, as selling price needs to be larger than buying price.

 Example 2:
 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 按照股票差价构成新数组 prices[1]-prices[0], prices[2]-prices[1],
     * prices[3]-prices[2], ..., prices[n-1]-prices[n-2]。求新数组的最大子段和就是我们求得最大利润，
     * 假设最大子段和是从新数组第 i 到第 j 项，
     * 那么子段和= prices[j]-prices[j-1]+prices[j-1]-prices[j-2]+...+prices[i]-prices[i-1] = prices[j]-prices[i-1],
     * 即prices[j]是最大价格，prices[i-1]是最小价格，且他们满足前后顺序关系
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1){
            return 0;
        }

        int res = 0, currsum = 0;
        for(int i = 1; i < len; i++)
        {
            if(currsum <= 0){
                currsum = prices[i] - prices[i-1];
            }else{
                currsum += prices[i] - prices[i-1];
            }

            if(currsum > res){
                res = currsum;
            }
        }
        return res;
    }


    @Test
    public void test(){
        Assert.assertEquals(5,maxProfit(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(0,maxProfit(new int[]{7,6,4,3,1}));
    }
}
