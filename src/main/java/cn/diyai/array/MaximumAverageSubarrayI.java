package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].

 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        int[] sums = nums;
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        double mx = sums[k - 1];
        for (int i = k; i < n; ++i) {
            mx = Math.max(mx, (double)sums[i] - sums[i - k]);
        }
        return mx / k;
    }

    @Test
    public void test(){
        Assert.assertEquals(12.75,findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
