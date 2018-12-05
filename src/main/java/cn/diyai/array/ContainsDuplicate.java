package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

//查找数组中是否有重复的元素
public class ContainsDuplicate {


    /**
     * Input: [1,2,3,1]
     Output: true
     Example 2:

     Input: [1,2,3,4]
     Output: false
     Example 3:

     Input: [1,1,1,3,3,4,3,2,4,2]
     Output: true

     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        if (nums.length < 2 ) {
            return false;
        }

        for(int i = 0 ; i < nums.length;i++){
            for(int j = i+1; j < nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //优化后的结果
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length < 2 ) {
            return false;
        }
        for (int i=1; i<nums.length; i++) {
            for(int j=i-1; j>=0; j--){

                //todo  ?
                if(nums[i] > nums[j]) break;
                
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        if (nums.length < 2 ) {
            return false;
        }
        for (int i=1; i<nums.length; i++) {
            for(int j=i-1; j>=0; j--){
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }



    @Test
    public void test(){

        Assert.assertEquals(false,containsDuplicate(new int[]{}));
        Assert.assertEquals(true,containsDuplicate(new int[]{1,2,3,1}));
        Assert.assertEquals(false,containsDuplicate(new int[]{1,2,3,4}));
        Assert.assertEquals(true,containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));

        Assert.assertEquals(false,containsDuplicate3(new int[]{}));
        Assert.assertEquals(true,containsDuplicate3(new int[]{1,2,3,1}));
        Assert.assertEquals(false,containsDuplicate3(new int[]{1,2,3,4}));
        Assert.assertEquals(true,containsDuplicate3(new int[]{1,1,1,3,3,4,3,2,4,2}));

    }
}
