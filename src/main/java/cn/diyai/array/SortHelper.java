package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SortHelper {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
     并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray(int[] array) {
        if (array.length == 0) {
            return;
        }

        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            if (val % 2 == 0) {
                evenList.add(val);
            } else {
                oddList.add(val);
            }
        }

        //将偶数加入到奇数的后面
        oddList.addAll(evenList);

        for (int i = 0; i < array.length; i++) {
            array[i] = oddList.get(i);
        }
    }

    @Test
    public void test(){
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        reOrderArray(arr);
        Assert.assertEquals(1,arr[0]);
        Assert.assertEquals(3,arr[1]);
        Assert.assertEquals(5,arr[2]);
        Assert.assertEquals(2,arr[3]);
        Assert.assertEquals(4,arr[4]);
        reOrderArray(new int[] {});
    }
}
