package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
/**
 *  求数组的最大和
 */
public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int s = nums[n-1] * nums[n-2] * nums[n-3];
        s = Math.max(s, nums[n-1] * nums[n-2] * nums[0]);
        s = Math.max(s, nums[n-1] * nums[1] * nums[0]);
        s = Math.max(s, nums[2] * nums[1] * nums[0]);
        return s;
    }

    //优化后
    public int maximumProduct2(int[] nums) {
        int max1, max2, max3, min1, min2;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > max1) { max3 = max2; max2= max1; max1 = n; }
            else if (n > max2) { max3 = max2; max2 = n; }
            else if (n > max3) { max3 = n; }

            if (n < min1) { min2 = min1; min1 = n; }
            else if (n < min2) { min2 = n; }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    @Test
    public void test(){
        Assert.assertEquals(6,maximumProduct(new int[]{1,2,3}));
        Assert.assertEquals(24,maximumProduct(new int[]{1,2,3,4}));

        Assert.assertEquals(6,maximumProduct2(new int[]{1,2,3}));
        Assert.assertEquals(24,maximumProduct2(new int[]{1,2,3,4}));
    }
}
