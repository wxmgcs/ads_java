package cn.diyai.sort;
// 插入排序
public class InsertionSort {
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
}
