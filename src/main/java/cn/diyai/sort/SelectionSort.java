package cn.diyai.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 对于一个int数组，请编写一个选择排序算法，对数组元素排序。
 给定一个int数组A及数组的大小n，请返回排序后的数组。

 测试样例：
 [1,2,3,5,2,3],6
 [1,2,2,3,3,5]
 */
public class SelectionSort extends Sort{
    public int[] selectionSort(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            //选择剩余元素中的最小值的下标
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            swap(A, i, min);
        }
        return A;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    @Test
    public void test(){
        Assert.assertEquals(true,
                super.check());
    }

    @Override
    public int[] exec(int[] arr, int len) {
        return selectionSort(arr,len);
    }
}
