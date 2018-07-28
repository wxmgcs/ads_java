package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * Leetcode 148
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2

 思路: 冒泡求和
 */
public class TwoSum {

    public int[] find(int [] numbers,int target){

        int[] ret = new int[2];
        //第几趟
        for(int i = 0; i < numbers.length;i++){
            int sum1 = numbers[i];
            for(int j = i+1; j < numbers.length;j++){
                if (numbers[j]+sum1 == target){
                    ret[0] = i+1;
                    ret[1] = j+1;
                    return ret;
                }
            }
        }

        return ret;
    }


    @Test
    public void test(){
        int[] ret = find(new int[]{2,7,15,11},9);
        Assert.assertEquals(1,ret[0]);
        Assert.assertEquals(2,ret[1]);

        ret = find(new int[]{2,7,15,7},9);
        Assert.assertEquals(1,ret[0]);
        Assert.assertEquals(2,ret[1]);

        ret = find(new int[]{7,2,15,7},9);
        Assert.assertEquals(1,ret[0]);
        Assert.assertEquals(2,ret[1]);


        ret = find(new int[]{7,12,2,7},9);
        Assert.assertEquals(1,ret[0]);
        Assert.assertEquals(3,ret[1]);
    }


}
