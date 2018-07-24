package cn.diyai.sort.bubblesort;

import cn.diyai.sort.Sort;
import com.sun.deploy.util.ArrayUtil;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort4 extends Sort{

    /**
     * /**
     * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
     给定一个int数组A及数组的大小n，请返回排序后的数组。
     */
    // 对 bubbleSort 的优化算法
    public int[] bubbleSort4(int[] list,int n) {
        int temp = 0; // 用来交换的临时数
        boolean bChange = false; // 交换标志

        // 要遍历的次数
        for (int i = 0; i < n - 1; i++) {
            bChange = false;
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = n - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    bChange = true;
                }
            }
            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (!bChange)
                break;
        }
        return list;
    }


    @Override
    public int[] exec(int[] arr, int len) {
        return bubbleSort4(arr,len);
    }

    public void test(){

        Assert.assertEquals(true,super.check());
    }

    @Test
    public void test1(){
        Assert.assertEquals(true,super.check2(new int[]{1,2,3,5,2,3}));
    }


}
