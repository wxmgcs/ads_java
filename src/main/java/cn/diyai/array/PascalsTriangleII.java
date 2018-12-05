package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex; i++) {
            temp.clear();
            temp.add(1);
            for (int j = 0; j < res.size() - 1; j++) {
                temp.add(res.get(j) + res.get(j + 1));
            }
            temp.add(1);
            res.clear();
            res.addAll(temp);
        }
        return res;
    }

    //优化后
    public List<Integer> getRow2(int rowIndex) {
        int[] result = new int[1];
        //result[0] = 1;
        for (int i = 0; i <= rowIndex; i++) {
            int[] next = new int[i + 1];
            next[0] = 1;
            next[i] = 1;
            for (int j = 1; j < i; j++) {
                next[j] = result[j - 1] + result[j];
            }
            result = next;
        }
        List<Integer> ans = new ArrayList();
        for (int in : result) {
            ans.add(in);
        }

        return ans;
    }

    @Test
    public void test() {
        List<Integer> ret = getRow(3);
        Assert.assertEquals(1, (int) ret.get(0));
        Assert.assertEquals(3, (int) ret.get(1));
        Assert.assertEquals(3, (int) ret.get(2));
        Assert.assertEquals(1, (int) ret.get(3));
    }
}
