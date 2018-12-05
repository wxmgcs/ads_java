package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

 Example 1:
 Input:
 nums = [1, 7, 3, 6, 5, 6]
 Output: 3
 Explanation:
 The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 Also, 3 is the first index where this occurs.

 Example 2:
 Input:
 nums = [1, 2, 3]
 Output: -1
 Explanation:
 There is no index that satisfies the conditions in the problem statement.
 Note:

 The length of nums will be in the range [0, 10000].
 Each element nums[i] will be an integer in the range [-1000, 1000]
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {

        int len  = nums.length;
        for(int i = 0; i<len; i++) {
            int left = i-1;
            int right = i+1;
            int suml = 0;
            int sumr = 0;
            while(left>=0) {
                suml += nums[left];
                left--;
            }
            while(right<len) {
                sumr += nums[right];
                right++;
            }
            if(suml == sumr) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int sum = 0, leftsum = 0;
        for (int x: nums){
            sum += x;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

    @Test
    public void test(){
        Assert.assertEquals(3,pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        Assert.assertEquals(-1,pivotIndex(new int[]{1, 2, 3}));
        Assert.assertEquals(3,pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
        Assert.assertEquals(-1,pivotIndex2(new int[]{1, 2, 3}));
    }
}
