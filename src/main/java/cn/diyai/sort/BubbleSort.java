package cn.diyai.sort;

//冒泡排序
public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

}
