package cn.diyai.sort.mergesort;

import cn.diyai.sort.Sort;
import org.junit.Test;

public class MergeSort3 extends Sort{

    public int[] mergeSort(int[] arr,int n){
        int[] b = new int[n];
        int len = 1;
        while(len < n){
            mergePass(arr,b,len,n);
            len = len * 2;
            mergePass(b,arr,len,n);
            len = len * 2;
        }

        return b;
    }

    private void mergePass(int[] arr,int[] b ,int len ,int n){
        //对arr【1...n]做一趟归并排序
        int i,j;
        for(i = 1; i+ 2* len -1 <= n ; i= i+2*len){
            merge(arr,b,i,i+len-1,n);
        }

        if(i + len-1 < n){
            merge(arr,b,i,i+len-1,n);
        }else{
            //个数为奇数,最后一个子文件复制到b中
            for(j = i; j <= n; j++){
                b[j] = arr[j];
            }
        }
    }

    private void merge(int[] arr,int[] b,int low,int m ,int high){
        int i,j,k;
        i = low;
        j= m+1;
        k = low;

        while(i <= m && j <= high){
            if(arr[i] <= arr[j]){
                b[k++] = arr[i++];
            }else {
                b[i++] = arr[j++];
            }
        }

        //将arr[low...m]中的剩余的复制到b中
        while (i <= m){
            b[k++] = arr[i++];
        }

        //将arr[m+1...high]中的剩余的复制到b中
        while(j <= high){
            b[k++] = arr[j++];
        }
    }

    @Override
    public int[] exec(int[] arr, int len) {
        return mergeSort(arr,len);
    }

    @Test
    public void test(){
        super.check2(new int[]{72,18,53,36,48,31,36});
    }

}
