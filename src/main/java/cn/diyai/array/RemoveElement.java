package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

public class RemoveElement {
    int[] nums;

    /**
     * Given nums = [3,2,2,3], val = 3,
     Your function should return length = 2, with the first two elements of nums being 2.
     It doesn't matter what you leave beyond the returned length.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int ret = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != val){
                nums[ret] = nums[i];
                ret++;
            }
        }
        return ret;
    }

    @Test
    public void test(){
        nums = new int[]{3,2,2,3};
        int rel = removeElement(nums,3);
        ArrayUtil.printArray(nums,rel);
        Assert.assertEquals(2,rel);

        nums = new int[]{0,1,2,2,3,0,4,2};
        rel = removeElement(nums,2);
        ArrayUtil.printArray(nums,rel);
        Assert.assertEquals(5,rel);

        nums = new int[]{};
        rel = removeElement(nums,2);
        ArrayUtil.printArray(nums,rel);
        Assert.assertEquals(0,rel);
    }
}
