package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

 Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [4,2,5,7]
 Output: [4,5,2,7]
 Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


 Note:

 2 <= A.length <= 20000
 A.length % 2 == 0
 0 <= A[i] <= 1000

 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;
        while (odd < A.length && even < A.length) {
            while (odd < A.length && A[odd] % 2 == 1){
                odd += 2;
            }
            while (even < A.length && A[even] % 2 == 0){
                even += 2;
            }
            if (odd >= A.length || even >= A.length){
                break;
            }
            A[odd] = A[odd] ^ A[even];
            A[even] = A[odd] ^ A[even];
            A[odd] = A[odd] ^ A[even];
        }
        return A;
    }

    @Test
    public void test(){
        int[] ret = sortArrayByParityII(new int[]{4,2,5,7});
        Assert.assertEquals(4,ret[0]);
        Assert.assertEquals(5,ret[1]);
        Assert.assertEquals(2,ret[2]);
        Assert.assertEquals(7,ret[3]);

    }
}
