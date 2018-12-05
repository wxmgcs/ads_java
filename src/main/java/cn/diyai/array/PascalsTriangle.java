package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * n Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 5
 Output:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0){
            return result;
        }

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            //first
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                //middle
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            //last
            cur.add(1);

            result.add(cur);
            pre = cur;
        }

        return result;
    }

    @Test
    public void test(){
        List<List<Integer>> ret = generate(5);
        Assert.assertEquals(1,(int)ret.get(0).get(0));
        Assert.assertEquals(1,(int)ret.get(1).get(0));
        Assert.assertEquals(1,(int)ret.get(1).get(1));
    }
}
