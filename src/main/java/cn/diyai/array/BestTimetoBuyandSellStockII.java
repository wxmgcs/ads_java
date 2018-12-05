package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int sum1 = 0;
            int j = i;
            while (j < prices.length - 1) {
                if (prices[j] < prices[j + 1]) {
                    sum1 = sum1 + prices[j + 1] - prices[j];
                    System.out.println("\t" + i + "-->(" + j + ":" + (j + 1) + "):" + sum1);
                    //fixme
                    j = j + 2;
                } else {
                    j++;
                }
            }

            j = i + 1;
            int sum2 = 0;
            while (j < prices.length) {
                if ((prices[i] < prices[j]) && (prices[j] - prices[i] > sum2)) {
                    sum2 = prices[j] - prices[i];
                    System.out.println("\t\t(" + i + "-->" + j + "):" + sum2);
                }
                j++;
            }

            sum1 = sum1 > sum2 ? sum1 : sum2;
            System.out.println(i + ":" + sum1);
            if (sum1 > max) {
                max = sum1;
            }

        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int buy = -1;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy == -1 || (prices[i] > prices[i - 1] && buy > prices[i - 1])) {
                buy = prices[i - 1];
            }
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - buy;
                buy = -1;
            }
        }
        if (buy != -1 && prices[prices.length - 1] > buy) {
            profit += prices[prices.length - 1] - buy;
        }
        return profit;
    }


    @Test
    public void test() {

//        Assert.assertEquals(7,maxProfit(new int[]{7,1,5,3,6,4}));
//        Assert.assertEquals(4,maxProfit(new int[]{1,2,3,4,5}));
//        Assert.assertEquals(0,maxProfit(new int[]{7,6,4,3,1}));
        Assert.assertEquals(7, maxProfit2(new int[]{6, 1, 3, 2, 4, 7}));

    }

}
