package cn.diyai.array;

import org.junit.Test;

/**
 *
 Example 1:
 Input: A = [1,1], B = [2,2]
 Output: [1,2]

 Example 2:
 Input: A = [1,2], B = [2,3]
 Output: [1,2]

 Example 3:
 Input: A = [2], B = [1,3]
 Output: [2,3]

 Example 4:
 Input: A = [1,2,5], B = [2,4]
 Output: [5,4]

 *
 */
public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {

        int aLength = A.length;
        int bLength = B.length;
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < aLength; i++) {
            sumA = sumA + A[i];
        }
        
        for (int i = 0; i < bLength; i++) {
            sumB = sumB + B[i];
        }
        
        int[] res = new int[2];
        if (sumA < sumB) {
            int diffrence = (sumB - sumA) / 2;
            for (int i = 0; i < aLength; i++) {
                for (int j = 0; j < bLength; j++) {
                    if (A[i] + diffrence - B[j] == 0) {
                        res[0] = A[i];
                        res[1] = B[j];
                        return res;
                    }
                }
            }
        }
        if (sumA > sumB) {
            int diffrence = (sumA - sumB) / 2;
            for (int j = 0; j < bLength; j++) {
                for (int i = 0; i < aLength; i++) {
                    if (B[j] + diffrence - A[i] == 0) {
                        res[0] = A[i];
                        res[1] = B[j];
                        return res;
                    }
                }
            }

        }
        return res;
    }


    @Test
    public void test(){

        int[] nums = fairCandySwap(new int[]{1,1},new int[]{2,2});
        ArrayUtil.printArray(nums);

        nums = fairCandySwap(new int[]{1,2},new int[]{2,3});
        ArrayUtil.printArray(nums);

        nums = fairCandySwap(new int[]{2},new int[]{1,3});
        ArrayUtil.printArray(nums);

        nums = fairCandySwap(new int[]{1,2,5},new int[]{2,4});
        ArrayUtil.printArray(nums);

    }
}
