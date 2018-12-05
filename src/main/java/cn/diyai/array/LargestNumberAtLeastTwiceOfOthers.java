package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int largestIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                largestIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != largestIndex && nums[i] * 2 > max) {
                return -1;
            }
        }
        return largestIndex;
    }

    //优化后
    public int dominantIndex2(int[] nums) {
        int theBiggestIndex = 0;
        int theBiggestValue = 0;

        if (nums.length == 1){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                continue;
            }

            if (nums[i] >= theBiggestValue * 2) {
                theBiggestValue = nums[i];
                theBiggestIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (theBiggestValue == nums[i]){
                continue;
            }

            if (nums[i] == 0){
                continue;
            }

            if (!(theBiggestValue >= 2 * nums[i])){
                return -1;
            }
        }

        return theBiggestIndex;
    }

    @Test
    public void test(){
        Assert.assertEquals(1,dominantIndex(new int[]{3, 6, 1, 0}));
    }
}
