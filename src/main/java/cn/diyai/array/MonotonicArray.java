package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Example 1:
 Input: [1,2,2,3]
 Output: true

 Example 2:
 Input: [6,5,4,4]
 Output: true

 Example 3:
 Input: [1,3,2]
 Output: false

 Example 4:
 Input: [1,2,4,5]
 Output: true

 Example 5:
 Input: [1,1,1]
 Output: true
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {

        if(A.length <= 1){
            return true;
        }

        int min = A[0];
        int max = A[A.length-1];
        //先判断是升序还是降序
        boolean isIncr =  false;
        if(min <= max){
            isIncr = true;
        }
        //可以优化的地方: 每次都需要判断是否是降序还是升序,可以放在最后一次判断
        for(int i = 0 ;i < A.length-1;i++){
            if((A[i] > A[i+1] && isIncr) || (A[i] < A[i+1] && !isIncr)){
                return false;
            }
        }
        return true;
    }

    //优化后
    //思路: 分别按照升序和降序,如果有符合的就返回
    public boolean isMonotonic2(int[] A) {
        boolean increasing = inc(A);
        boolean decreasing = dec(A);
        if(increasing||decreasing) {
            return true;
        }
        return false;
    }

    //判断是否是升序
    public boolean inc(int[] A) {
        for (int i = 0;i < A.length-1;i++) {
            if (A[i] > A[i+1]) {
                return false;
            }
        }
        return true;
    }

    //判断是否是降序
    public boolean dec(int[] A) {
        for (int i = 0;i < A.length-1;i++) {
            if (A[i] < A[i+1]) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        Assert.assertEquals(true,isMonotonic(new int[]{1,2,2,3}));
        Assert.assertEquals(true,isMonotonic(new int[]{6,5,4,4}));
        Assert.assertEquals(false,isMonotonic(new int[]{1,3,2}));
        Assert.assertEquals(true,isMonotonic(new int[]{1,2,4,5}));
        Assert.assertEquals(true,isMonotonic(new int[]{1,1,1}));
        Assert.assertEquals(true,isMonotonic(new int[]{1,1,2}));
        Assert.assertEquals(true,isMonotonic(new int[]{1}));
        Assert.assertEquals(true,isMonotonic(new int[]{1,1}));
        Assert.assertEquals(false,isMonotonic(new int[]{5,3,2,4,1}));
        Assert.assertEquals(false,isMonotonic(new int[]{3,1,9}));

    }
}
