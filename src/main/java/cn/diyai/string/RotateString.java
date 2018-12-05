package cn.diyai.string;

import junit.framework.Assert;
import org.junit.Test;

/**
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
 * For example, if A = 'abcde',
 * then it will be 'bcdea' after one shift on A.
 * Return True if and only if A can become B after some number of shifts on A.
 Example 1:
 Input: A = 'abcde', B = 'cdeab'
 Output: true
 Example 2:
 Input: A = 'abcde', B = 'abced'
 Output: false
 Note:
 A and B will have length at most 100.

 这道题给了我们两个字符串A和B，定义了一种偏移操作，
 以某一个位置将字符串A分为两截，并将两段调换位置，如果此时跟字符串B相等了，
 就说明字符串A可以通过偏移得到B。现在就是让我们判断是否存在这种偏移，
 那么最简单最暴力的方法就是遍历所有能将A分为两截的位置，然后用取子串的方法将A断开，交换顺序，
 再去跟B比较，如果相等，返回true即可，遍历结束后，返回false
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length() == 0 && A.length() == B.length()) {
            return true;
        }

        if (A.length() != B.length()){
            return false;
        }

        for (int i = 0; i < A.length(); i++) {
            String part1 = A.substring(i, A.length());
            String part2 = A.substring(0, i);

            if (( part1 +part2 ).equals(B)){
                return true;
            }
        }
        return false;
    }

    //优化
    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }



    @Test
    public void test(){
        Assert.assertEquals(true,rotateString("abcde","cdeab"));
        Assert.assertEquals(false,rotateString("abcde","abced"));
        Assert.assertEquals(true,rotateString("",""));

        Assert.assertEquals(true,rotateString2("abcde","cdeab"));
        Assert.assertEquals(false,rotateString2("abcde","abced"));
        Assert.assertEquals(true,rotateString2("",""));

    }

}
