package cn.diyai.sort.insertionsort;

import cn.diyai.sort.Sort;
import org.junit.Assert;
import org.junit.Test;


// 插入排序
public class InsertionSort2 extends Sort{
    /**
     * 对于一个int数组，请编写一个插入排序算法，对数组元素排序。
     给定一个int数组A及数组的大小n，请返回排序后的数组。

     测试样例：
     [1,2,3,5,2,3],6
     [1,2,2,3,3,5]
     * @return
     */
    public int[] insertionSort2(int[] arr,int n) {
        if (arr == null || n < 2) {
            return arr;
        }
        int index = 0;
        for (int i = 1; i < n; i++) {
            index = i;
            while (index > 0) {
                if (arr[index - 1] > arr[index]) {
                    swap(arr, index - 1, index);
                    index--;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }



    @Override
    public int[] exec(int[] arr, int len) {
        return insertionSort2(arr,len);
    }


    @Test
    public void test(){
        Assert.assertEquals(true,super.check());
    }
}
