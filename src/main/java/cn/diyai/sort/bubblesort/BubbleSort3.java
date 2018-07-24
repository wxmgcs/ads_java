package cn.diyai.sort.bubblesort;

import cn.diyai.sort.Sort;
import com.sun.deploy.util.ArrayUtil;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort3 extends Sort{

    /**
     * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
     给定一个int数组A及数组的大小n，请返回排序后的数组。
     * @param A
     * @param n
     * @return
     */

    public int[] bubbleSort3(int[] A, int n) {

        if(A.length != n){
            return A;
        }

        int temp = 0;
        int i =0;
        while(i++ < n){
            for(int j = 0;j < n-1;j++){
                if(A[j] > A[j+1]){
                    temp =  A[j];
                    A[j] = A[j+1];
                    A[j+1] =temp;
                }
            }
        }
        return A;
    }


    @Override
    public int[] exec(int[] arr, int len) {
        return bubbleSort3(arr,len);
    }

    public void test(){

        Assert.assertEquals(true,super.check());
    }

    @Test
    public void test1(){
        Assert.assertEquals(true,super.check2(new int[]{1,2,3,5,2,3}));
    }
}
