package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * We are to write the letters of a given string S,
 * from left to right into lines. Each line has maximum width 100 units,
 * and if writing a letter would cause the width of the line to exceed 100 units,
 * it is written on the next line.
 * We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ...,
 * and widths[25] is the width of 'z'.
 * <p>
 * Now answer two questions: how many lines have at least one character from S,
 * and what is the width used by the last such line?
 * Return your answer as an integer list of length 2.
 *
 * 这道题给了我们一个字符串，让我们把里面的字母写下来，规定了每一行的长度为100，
 * 然后每个字母的长度可以在widths数组中查询，说是如果某一个字母加上后超过了长度100的限制，
 * 那么就移动到下一行，问我们最终需要多少行，和最后一行的长度。这道题并没有太大的难度和技巧，
 * 就是楞头写呗，遍历所有的字母，然后查表得到其宽度，然后看加上这个新宽度是否超了100，超了的话，
 * 行数计数器自增1，并且当前长度为这个字母的长度，因为另起了一行。如果没超100，
 * 那么行长度就直接加上这个字母的长度。遍历完成后返回行数和当前行长度即可
 */
public class NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String S) {
        int cnt = 1, cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int t = widths[c - 'a'];
            if (cur + t > 100) {
                ++cnt;
            }
            cur = (cur + t > 100) ? t : cur + t;
        }
        return new int[]{cnt, cur};
    }

    //优化算法
    public int[] numberOfLines2(int[] widths, String S) {

        if (S == null || S.length() == 0) {
            return new int[]{0, 0};
        }

        char[] sArray = S.toCharArray();
        int total = 0;
        int count = 1;
        for (int i = 0; i < sArray.length; i++) {
            int widthI = widths[sArray[i] - 'a'];
            if (total + widthI > 100) {
                total = widthI;
                count++;
            } else {
                total += widthI;
            }
        }
        return new int[]{count, total};
    }

    @Test
    public void test() {

        int[] ret = numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                "abcdefghijklmnopqrstuvwxyz");

        Assert.assertEquals(3, ret[0]);
        Assert.assertEquals(60, ret[1]);

        ret = numberOfLines2(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                "abcdefghijklmnopqrstuvwxyz");

        Assert.assertEquals(3, ret[0]);
        Assert.assertEquals(60, ret[1]);

        ret = numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                "bbbcccdddaaa");
        Assert.assertEquals(2, ret[0]);
        Assert.assertEquals(4, ret[1]);

        ret = numberOfLines2(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                "bbbcccdddaaa");
        Assert.assertEquals(2, ret[0]);
        Assert.assertEquals(4, ret[1]);
    }
}
