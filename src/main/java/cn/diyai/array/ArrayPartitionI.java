package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

public class ArrayPartitionI {

    /**
     * Input: [1,4,3,2]

     Output: 4
     Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).*

     1. n is a positive integer, which is in the range of [1, 10000].
     2. All the integers in the array will be in the range of [-10000, 10000].

     思路: 冒泡排序后取前4位的最小值
     * @param nums
     * @return
     */
    int[] nums;
    public int arrayPairSum(int[] nums) {

        if(nums.length < 4){
            return nums[0] > nums[1]? nums[1]: nums[0];
        }

        //冒泡排序
        boolean swaped;
        int n = nums.length;
        do {
            swaped = false;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] > nums[i]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                    swaped = true;
                }
            }
            n--;
        } while (swaped);

        int length = nums.length;
        //取前4位的最小值
        int pre = (nums[length-4] > nums[length-3]? nums[length-3]: nums[length-4]);
        int post = (nums[length-2] > nums[length-1]? nums[length-1]: nums[length-2]);
        return pre + post;
    }


    //优化后算法
    //todo
    public  int arrayPairSum2(int[] nums){
        int shift = 10000;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // to store the freq of of num
        // each index maps to number "index - shift"
        int[] count = new int[2 * shift + 1];

        for (int num : nums) {
            int index = num + shift;
            count[index]++;
        }

        int res = 0;
        boolean first = true; // need to chose first element
        for (int index = 0; index < count.length; index++) {
            while (count[index] != 0) {
                if (first) {
                    int num = index - shift;
                    res += num;
                    count[index]--;
                    first = false;
                } else { // has chosen the first element, skip the second
                    count[index]--;
                    first = true;
                }
            }
        }

        return res;
    }


    @Test
    public void test(){
        int rel;
//        nums = new int[]{1,4,3,2};
//        rel = arrayPairSum(nums);
//        Assert.assertEquals(4,rel);
//        ArrayUtil.printArray(nums);
//
//        nums = new int[]{1,4};
//        rel = arrayPairSum(nums);
//        Assert.assertEquals(1,rel);
//        ArrayUtil.printArray(nums);
//
//        nums = new int[]{7,3,1,0,0,6};
//        rel = arrayPairSum(nums);
//        ArrayUtil.printArray(nums);
//        Assert.assertEquals(7,rel);
//
//        nums = new int[]{9,1,5,6,7,2};
//        rel = arrayPairSum(nums);
//        ArrayUtil.printArray(nums);
//        Assert.assertEquals(13,rel);


        nums = new int[]{1,4,3,2};
        rel = arrayPairSum2(nums);
        Assert.assertEquals(4,rel);
        ArrayUtil.printArray(nums);

        nums = new int[]{1,4};
        rel = arrayPairSum2(nums);
        Assert.assertEquals(1,rel);
        ArrayUtil.printArray(nums);

        nums = new int[]{7,3,1,0,0,6};
        rel = arrayPairSum2(nums);
        ArrayUtil.printArray(nums);
        Assert.assertEquals(7,rel);

        nums = new int[]{9,1,5,6,7,2};
        rel = arrayPairSum2(nums);
        ArrayUtil.printArray(nums);
        Assert.assertEquals(13,rel);

    }
}
