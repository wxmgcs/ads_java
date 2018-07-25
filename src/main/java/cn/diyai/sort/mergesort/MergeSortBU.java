package cn.diyai.sort.mergesort;

import cn.diyai.sort.Sort;
import org.junit.Test;

//自顶向上的归并排序
public class MergeSortBU extends Sort {
    public int[] mergeSort(int[] A, int n) {
        for (int sz = 1; sz < n; sz *= 2) {
            for (int lo = 0; lo < n - sz; lo += sz * 2) {
                merge(A, lo, lo + sz - 1, Math.min(lo + sz * 2 - 1, n - 1));
            }
        }
        return A;
    }
    public void merge(int[] A, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int[] B = new int[hi - lo + 1];
        for (int k = 0; k <= hi - lo; k++) {
            if (i > mid) {
                B[k] = A[j++];
            } else if (j > hi) {
                B[k] = A[i++];
            } else if (A[i] < A[j]) {
                B[k] = A[i++];
            } else {
                B[k] = A[j++];
            }
        }
        for (int k = 0; k <= hi - lo; k++) {
            A[lo + k] = B[k];
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
