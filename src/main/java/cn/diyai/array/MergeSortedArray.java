package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:

 The number of elements initialized in nums1 and nums2 are m and n respectively.
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 Example:

 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    int[] nums1 = new int[]{1,2,3,0,0,0};
    int[] nums2 = new int[]{2,5,6};

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m <= 0 && n <= 0) {
            return;
        }
        int a = 0, b = 0;
        int[] C = new int[m+n];
        for (int i = 0; i < m + n; ++i) {
            if (a < m && b < n) {
                if (nums1[a] < nums2[b]) {
                    C[i] = nums1[a];
                    ++a;
                } else {
                    C[i] = nums2[b];
                    ++b;
                }
            } else if (a < m && b >= n) {
                C[i] = nums1[a];
                ++a;
            } else if (a >= m && b < n) {
                C[i] = nums2[b];
                ++b;
            } else{
                return;
            }
        }
        for (int i = 0; i < m + n; ++i) {
            nums1[i] = C[i];
        }
    }

    /**
     * 算法思想是：由于合并后A数组的大小必定是m+n，所以从最后面开始往前赋值，先比较A和B中最后一个元素的大小，
     * 把较大的那个插入到m+n-1的位置上，再依次向前推。如果A中所有的元素都比B小，那么前m个还是A原来的内容，没有改变。
     * 如果A中的数组比B大的，当A循环完了，B中还有元素没加入A，直接用个循环把B中所有的元素覆盖到A剩下的位置
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        --m; --n;
        while (m >= 0 && n >= 0) {
            nums1[count--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0){
            nums1[count--] = nums2[n--];
        }
    }

    @Test
    public void test(){
        //merge(nums1,3,nums2,3);
        merge2(nums1,3,nums2,3);
        Assert.assertEquals(6,nums1.length);
        Assert.assertEquals(1,nums1[0]);
        Assert.assertEquals(2,nums1[1]);
        Assert.assertEquals(2,nums1[2]);
        Assert.assertEquals(3,nums1[3]);
        Assert.assertEquals(5,nums1[4]);
        Assert.assertEquals(6,nums1[5]);
    }

}
