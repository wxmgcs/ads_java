package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 */
public class DegreeOfAnArray {

    /**
     * 思路:记录下第一次出现和最后一次出现的位置就好了，两者相减就是最短长度。对于有多个出现次数最多元素的情况，只需要找出这些元素的最短子串中最小的就好了。
     * * *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap();
        Map<Integer, Integer> right = new HashMap();
        Map<Integer, Integer> count = new HashMap();

        for(int i=0; i < nums.length; i++ ){
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }

        int degree = Collections.max(count.values());
        int length = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(count.get(nums[i])==degree){
                length = Math.min(length, right.get(nums[i]) - left.get(nums[i]) + 1);
            }
        }
        return length;
    }

    //方法2
    public int findShortestSubArray0(int[] nums) {
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            max = Integer.max(nums[i],max);      //找到最大的数
        }

        int[] count = new int[max+1];          //建一个数组用来记录次数

        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }

        int shortestLen = -1;
        int maxFreq = 1;
        int foundLeft;
        int foundRight;
        boolean foundL;
        boolean foundR;

        for(int i=0;i<count.length;i++){
            int num = count[i];
            if(num>1 && num>=maxFreq){
                if(num>maxFreq){
                    shortestLen = -1;
                }
                maxFreq = count[i];
                foundLeft=0;
                foundRight=nums.length-1;
                foundL=false;
                foundR=false;
                while(!foundL || !foundR){
                    if(!foundL){
                        if(nums[foundLeft]==i)
                            foundL = true;
                        else
                            foundLeft++;
                    }
                    if(!foundR){
                        if(nums[foundRight]==i)
                            foundR=true;
                        else
                            foundRight--;
                    }
                }

                if(shortestLen==-1){
                    shortestLen = foundRight-foundLeft+1;
                }
                else{
                    shortestLen = Math.min(shortestLen,foundRight-foundLeft+1);
                }
            }
        }
        if(shortestLen==-1)
            shortestLen=1;
        return shortestLen;
    }

    //方法3
    public int findShortestSubArray2(int[] nums) {
        int[] firstIdx = new int[50000];
        int[] freq = new int[50000];
        int degree = 1, shortest = 1;
        for(int k = 0; k < nums.length; k++) {
            int nowElement = nums[k];
            freq[nowElement] ++;
            if(firstIdx[nowElement] == 0) {
                firstIdx[nowElement] = k+1;
            }else if(freq[nowElement] == degree) {
                int tempSubLength = k+2-firstIdx[nowElement];
                if(tempSubLength < shortest) {shortest = tempSubLength;}
            }else if(freq[nowElement] > degree){
                degree = freq[nowElement];
                shortest = k+2-firstIdx[nowElement];
            }
        }
        return shortest;
    }

    //方法4
    public int findShortestSubArray3(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            }
        }
        return res;
    }


    @Test
    public void test(){

        Assert.assertEquals(2,findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        Assert.assertEquals(6,findShortestSubArray(new int[]{1,2,2,3,1,4,2}));

        Assert.assertEquals(2,findShortestSubArray0(new int[]{1, 2, 2, 3, 1}));
        Assert.assertEquals(6,findShortestSubArray0(new int[]{1,2,2,3,1,4,2}));

        Assert.assertEquals(2,findShortestSubArray2(new int[]{1, 2, 2, 3, 1}));
        Assert.assertEquals(6,findShortestSubArray2(new int[]{1,2,2,3,1,4,2}));

        Assert.assertEquals(2,findShortestSubArray3(new int[]{1, 2, 2, 3, 1}));
        Assert.assertEquals(6,findShortestSubArray3(new int[]{1,2,2,3,1,4,2}));
    }

}
