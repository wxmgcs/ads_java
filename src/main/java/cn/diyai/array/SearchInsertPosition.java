package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        if (size == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }

        for (int i = 0; i < size - 1; i++) {
            if (target <= nums[i]) {
                return i;
            }

            if (target > nums[i] && target <= nums[i + 1]) {
                return i + 1;
            }
        }
        return size;
    }

    //优化后
    public int searchInsert2(int[] nums, int target) {
        if( nums == null || nums.length == 0) {
            return -1;
        }

        int s = 0, e=nums.length - 1;
        while(true) {
            if(target<=nums[s]) {
                return s;
            }
            if(target>nums[e]) {
                return e+1;
            }
            final int m = (s+e)/2;
            if(nums[m] >= target) {
                e = m;
            } else {
                s = m+1;
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
        Assert.assertEquals(0, searchInsert(new int[]{1}, 0));
        Assert.assertEquals(0, searchInsert(new int[]{1}, 1));
        Assert.assertEquals(0, searchInsert(new int[]{1,3}, 1));
    }
}
