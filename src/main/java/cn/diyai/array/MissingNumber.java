package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1:
 Input: [3,0,1]
 Output: 2

 Example 2:
 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


 */
public class MissingNumber {
    /**
     * 思路: 思想是把数组的下标作为一个记录,将数组中出现的值当作索引位置,
     * 将该索引下标的位置的数该为0,依次遍历一遍,
     * 最后不是0的那个数的下标就是数组中没有出现的数
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int[] arr =  new int[nums.length+1];

        //fixme
        for(int i = 0 ;i < arr.length-1;i++){
            if(arr[nums[i]] != 0){
                return nums[i];
            }
        }
        return 0;
    }

    //优化后
    //利用位运算的特性。相同数的异或运算为0,所以呢,取0~n的数与数组中的数异或,
    // 数组中没有出现的那个数,就是异或后得到的值。
    public int missingNumber2(int[] nums){
        int missNum = 0;
        int length = nums.length;
        for(int i = 0 ;i < length;i++){
            missNum = missNum ^ nums[i] ^ i;
        }
        return missNum ^ length;
    }

    //优化后
    public int missingNumber3(int[] nums){
        int n = nums.length;
        int sum = n*(n+1)/2;
        int s=0;
        for(int x: nums) {
            s +=x;
        }
        return (sum-s);
    }



    @Test
    public void test(){
        Assert.assertEquals(2,missingNumber3(new int[]{3,0,1}));
        Assert.assertEquals(8,missingNumber3(new int[]{9,6,4,2,3,5,7,0,1}));

        Assert.assertEquals(2,missingNumber2(new int[]{3,0,1}));
        Assert.assertEquals(8,missingNumber2(new int[]{9,6,4,2,3,5,7,0,1}));

        Assert.assertEquals(2,missingNumber(new int[]{3,0,1}));
        Assert.assertEquals(8,missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
