package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution,
 try coding another solution using the divide and conquer approach, which is more subtle.


 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int curMaxSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            curMaxSum = Math.max(curMaxSum + nums[i], nums[i]);
            maxSum = Math.max(curMaxSum, maxSum);
        }
        return maxSum;
    }

    @Test
    public void test(){
        Assert.assertEquals(6,maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        Assert.assertEquals(-1,maxSubArray(new int[]{-2,-1}));
    }
}

