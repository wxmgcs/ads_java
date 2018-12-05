package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 Example 1:
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.

 Example 2:
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 Note: Length of the array will not exceed 10,000.

 最长递增子序列
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if( nums == null || nums.length == 0){
            return 0;
        }

        int max = 1;
        int temp = 1;
        for(int i = 1; i < nums.length;i++){
            if(nums[i-1] < nums[i]){
                temp++;
            }else{
                if(temp > max){
                    max = temp;
                    temp = 1;
                }
            }
        }
        return max > temp ? max: temp;
    }

    //优化
    public int findLengthOfLCIS2(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }

        int max = 1;
        for (int i = 1, k = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                k ++;
                max = Math.max(max, k);
            }
            else {
                k = 1;
            }
        }
        return max;
    }

    //优化
    public int findLengthOfLCIS3(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
                //只要大于就赋值
                if (cnt > max) {
                    max = cnt;
                }
            } else {
                cnt = 1;
            }
        }
        return max;
    }

    @Test
    public void test(){
        Assert.assertEquals(0,findLengthOfLCIS(new int[]{}));
        Assert.assertEquals(3,findLengthOfLCIS(new int[]{1,3,5,4,7}));
        Assert.assertEquals(4,findLengthOfLCIS(new int[]{1,3,5,7}));
        Assert.assertEquals(1,findLengthOfLCIS(new int[]{2,2,2,2,2}));

        Assert.assertEquals(0,findLengthOfLCIS2(new int[]{}));
        Assert.assertEquals(3,findLengthOfLCIS2(new int[]{1,3,5,4,7}));
        Assert.assertEquals(4,findLengthOfLCIS2(new int[]{1,3,5,7}));
        Assert.assertEquals(1,findLengthOfLCIS2(new int[]{2,2,2,2,2}));

        Assert.assertEquals(0,findLengthOfLCIS3(new int[]{}));
        Assert.assertEquals(3,findLengthOfLCIS3(new int[]{1,3,5,4,7}));
        Assert.assertEquals(4,findLengthOfLCIS3(new int[]{1,3,5,7}));
        Assert.assertEquals(1,findLengthOfLCIS3(new int[]{2,2,2,2,2}));
    }
}
