package cn.diyai.sort.mergesort;

import cn.diyai.sort.Sort;
import org.junit.Test;

/**
 * 对于一个int数组，请编写一个归并排序算法，对数组元素排序。
 给定一个int数组A及数组的大小n，请返回排序后的数组。
 测试样例：
 [1,2,3,5,2,3],6
 [1,2,2,3,3,5]
 */
public class MergeSort extends Sort{
    public int[] mergeSort(int[] A, int n) {
        mergeS(A, 0, A.length - 1);
        return A;
    }
    public void mergeS(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeS(A, start, mid);
        mergeS(A, mid + 1, end);
        mergeArray(A, start, mid, end);
    }
    public void mergeArray(int[] A, int start, int mid, int end) {
        int[] B = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;
        //两段一起向右移动
        while (left <= mid && right <= end) {
            //将两段指针较小的值存入新的数组中
            if (A[left] <= A[right]) {
                B[index++] = A[left++];
            } else {
                B[index++] = A[right++];
            }
        }
        while (left <= mid) {
            B[index++] = A[left++];
        }
        while (right <= end) {
            B[index++] = A[right++];
        }
        for (int i = 0; i <= end - start; i++) {
            A[start + i] = B[i];
        }
    }


    @Override
    public int[] exec(int[] arr, int len) {
        return mergeSort(arr,len);
    }

    @Test
    public void test(){
        super.check();
    }
}
