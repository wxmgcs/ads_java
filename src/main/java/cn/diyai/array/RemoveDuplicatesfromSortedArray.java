package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;


// 26. Remove Duplicates from Sorted Array
public class RemoveDuplicatesfromSortedArray {
    int[] nums ;

    //7 ms
    //找出非重复的数字,并移到数组的前面
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int min = nums[0];
        int index = 1;
        for(int i = 1; i < nums.length;i++ ){
            if (nums[i] > min){
                min = nums[i];
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    @Test
    public void test(){

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Assert.assertEquals(5,removeDuplicates(nums));
        ArrayUtil.printArray(nums);

        Assert.assertEquals(0,removeDuplicates(new int[]{}));

        nums = new int[]{1,1,2};
        Assert.assertEquals(2,removeDuplicates(nums));
        ArrayUtil.printArray(nums);
    }
}
