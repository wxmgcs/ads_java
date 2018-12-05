package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * <p>
 * Example 2:
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * <p>
 * Example 3:
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 */
public class PositionsOfLargeGroups {

    //fixme
    public List<List<Integer>> largeGroupPositions(String S) {
        int count = 1, pos = 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        char[] s1 = S.toCharArray();

        for (int i = 0; i < S.length()-1; i++) {
            List<Integer> tmp  = new ArrayList<>(2);
            if (s1[i] == s1[i + 1]){
                count++;
            }else {
                if (count >= 3) {
                    tmp.add(pos);
                    tmp.add(pos + count - 1);
                    res.add(tmp);
                }
                pos = i + 1;
                count = 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        List<List<Integer>> ret = largeGroupPositions("abbxxxxzzy");
        Assert.assertEquals(3, (int) ret.get(0).get(0));
        Assert.assertEquals(6, (int) ret.get(0).get(1));

        ret = largeGroupPositions("aaa");
        Assert.assertEquals(1, ret.size());
        Assert.assertEquals(0, (long)ret.get(0).get(0));
        Assert.assertEquals(2, (long)ret.get(0).get(1));
    }
}
