package cn.diyai.bit;

import junit.framework.Assert;
import org.junit.Test;

public class HammingDistance {

    /**
     * Note:
     * 0 ≤ x, y < 2的31次方.
     * <p>
     * 思路: 异或的性质上相同的为0，不同的为1，我们只要把为1的情况累加起来就是汉明距离了
     *
     * @param x
     * @param y
     * @return
     */
    private int hammingDistance2(int x, int y) {
        int i = x ^ y;
        int count=0;
        while (i != 0) {
            ++count;
            i = (i-1)& i;
        }
        return count;
    }

    //优化
    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor > 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    private String toBinaru(int num) {
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num = num / 2;
        }
        return str;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, hammingDistance2(1, 4));
        Assert.assertEquals(2, hammingDistance3(1, 4));

    }
}
