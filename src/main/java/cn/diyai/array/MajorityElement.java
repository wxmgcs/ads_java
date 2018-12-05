package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

//找出数组中出现最多的元素
public class MajorityElement {


    //思路：冒泡统计超过半数的元素
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }

                if (count > nums.length / 2) {
                    return nums[i];
                }
            }
        }
        return nums[0];
    }

    //优化后
    //思路: 如果说某个值大于半数,可以使用相抵策略，
    public int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }


    @Test
    public void test() {

        Assert.assertEquals(3, majorityElement(new int[]{3, 2, 3}));
        Assert.assertEquals(2, majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        Assert.assertEquals(1, majorityElement(new int[]{2, 1, 1, 1, 1, 2, 2}));
        Assert.assertEquals(1, majorityElement(new int[]{1}));
        Assert.assertEquals(1, majorityElement(new int[]{1, 2, 3}));
        Assert.assertEquals(5, majorityElement(new int[]{6, 5, 5}));

        Assert.assertEquals(3, majorityElement2(new int[]{3, 2, 3}));
        Assert.assertEquals(2, majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
        Assert.assertEquals(1, majorityElement2(new int[]{2, 1, 1, 1, 1, 2, 2}));
        Assert.assertEquals(1, majorityElement2(new int[]{1}));
        Assert.assertEquals(3, majorityElement2(new int[]{1, 2, 3}));
        Assert.assertEquals(5, majorityElement2(new int[]{6, 5, 5}));
    }
}
