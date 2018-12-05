package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * Example 1:
 * Input: [2,1]
 * Output: false
 * <p>
 * Example 2:
 * Input: [3,5,5]
 * Output: false
 * <p>
 * Example 3:
 * Input: [0,3,2,1]
 * Output: true
 */
public class ValidMountainArray {
    /**
     * 要求只有一个山峰，用双指针，分别从两边往中间爬，
     * 判断最终两个指针是否指向同一个值而且在范围内
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {

        int i = 0, j = A.length - 1, lenA = A.length;
        while (i + 1 < lenA && A[i + 1] > A[i]) {
            i++;
        }

        while (j - 1 >= 0 && A[j - 1] > A[j]) {
            j--;
        }

        return i == j && i > 0 && j < lenA - 1;
    }

    @Test
    public void test() {
        Assert.assertEquals(false, validMountainArray(new int[]{2, 1}));
        Assert.assertEquals(false, validMountainArray(new int[]{3, 5, 5}));
        Assert.assertEquals(true, validMountainArray(new int[]{0, 3, 2, 1}));
    }

}

