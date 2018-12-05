package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * 寻找数组中最大的数据的位置*
 * Example 1:

 Input: [0,1,0]
 Output: 1
 Example 2:

 Input: [0,2,1,0]
 Output: 1
 *
 */
public class PeakIndexInAMountainArray {


    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i++){
            if (A[i] > A[i-1] && A[i] > A[i+1]){
                return i;
            }
        }
        return 0;

    }

    //优化后
    public int peakIndexInMountainArray2(int[] A) {
        int l = 0,u= A.length-1;
        int mid = (l+u)/2;
        while( !(A[mid]>A[mid-1] && A[mid]>A[mid+1]) ){
            if(A[mid]>A[mid-1]){
                l = mid+1;
            }
            else{
                u=mid-1;
            }
            mid = (l+u)/2;
        }
        return mid;
    }


    public int peakIndexInMountainArray3(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1]){
                lo = mi + 1;
            }else{
                hi = mi;
            }

        }
        return lo;
    }

    @Test
    public void test(){

        Assert.assertEquals(1,peakIndexInMountainArray(new int[]{0,1,0}));
        Assert.assertEquals(1,peakIndexInMountainArray(new int[]{0,2,1,0}));

        Assert.assertEquals(1,peakIndexInMountainArray2(new int[]{0,1,0}));
        Assert.assertEquals(1,peakIndexInMountainArray2(new int[]{0,2,1,0}));

        Assert.assertEquals(1,peakIndexInMountainArray3(new int[]{0,1,0}));
        Assert.assertEquals(1,peakIndexInMountainArray3(new int[]{0,2,1,0}));

    }
}
