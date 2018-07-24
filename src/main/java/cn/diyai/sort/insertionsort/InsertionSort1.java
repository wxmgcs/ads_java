package cn.diyai.sort.insertionsort;

import cn.diyai.sort.Sort;
import org.junit.Assert;
import org.junit.Test;


// 插入排序
public class InsertionSort1 extends Sort{
    /**
     * 对于一个int数组，请编写一个插入排序算法，对数组元素排序。
     给定一个int数组A及数组的大小n，请返回排序后的数组。

     测试样例：
     [1,2,3,5,2,3],6
     [1,2,2,3,3,5]
     * @param A
     * @param n
     * @return
     */
    public int[] insertionSort(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] > A[j + 1]) {
                    swap(A, j + 1, j);
                }
            }
        }
        return A;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    @Override
    public int[] exec(int[] arr, int len) {
        return insertionSort(arr,len);
    }

    @Test
    public void test(){
        Assert.assertEquals(true,super.check());
    }
}
