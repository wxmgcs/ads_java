package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

//查找一个只包含0和1的数组,找出连续为1的元素的个数
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int temp = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 1){
                if(sum > temp){
                    temp = sum;
                }
                sum = 0;
            }else{
                sum++;
            }
        }
        return sum > temp? sum:temp;
    }

    @Test
    public void test(){

        Assert.assertEquals(3,findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        Assert.assertEquals(6,findMaxConsecutiveOnes(new int[]{1,1,1,1,1,1}));
        Assert.assertEquals(0,findMaxConsecutiveOnes(new int[]{0,0,0,0,0,0}));
        Assert.assertEquals(2,findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
