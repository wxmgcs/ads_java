package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.

 Example 1:

 Input: nums = [1,2,3,1], k = 3
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1
 Output: true
 Example 3:

 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false
 */
public class ContainsDuplicateII {

    /**
     * 只许有一组重复的数字，而且他们坐标差不能超过k
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){

            if(i > k) {
                set.remove(nums[i - k - 1]);
            }

            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        Assert.assertEquals(true,containsNearbyDuplicate(new int[]{1,2,3,1 },3));
        Assert.assertEquals(true,containsNearbyDuplicate(new int[]{1,0,1,1},1));
        Assert.assertEquals(false,containsNearbyDuplicate(new int[]{1,2,3,1,2,3 },2));
    }
}
