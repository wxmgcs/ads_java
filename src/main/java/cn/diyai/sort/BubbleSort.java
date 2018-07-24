package cn.diyai.sort;

import cn.diyai.util.ArrayUtil;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort{

    /**
     * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
     给定一个int数组A及数组的大小n，请返回排序后的数组。

     思路： 两个for循环，循环比较，被比较的值大
     * @param A
     * @param n
     * @return
     */
    public int[] bubbleSort(int[] A, int n) {

        if(A.length != n){
            return A;
        }

        int temp = 0;
        for(int i = 0;i <  n;i++){
            for(int j = 1;j < n-i;j++){
                if(A[j-1] > A[j]){
                    temp =  A[j];
                    A[j] = A[j-1];
                    A[j-1] =temp;
                }
            }
        }
        return A;
    }

    public int[] bubbleSort2(int[] A, int n) {

        if(A.length != n){
            return A;
        }

        int temp = 0;
        for(int i = 0;i <  n;i++){
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

    // 打印完整序列
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

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

    /**
     * [1,2,3,5,2,3],6
        [1,2,2,3,3,5]
     */
    @Test
    public void testBubbleSort(){

        //方法1
        Assert.assertEquals(Arrays.toString(new int[]{1,2,2,3,3,5})
                ,Arrays.toString(bubbleSort(new int[]{1,2,3,5,2,3},6)));

        //方法2
        Assert.assertEquals(Arrays.toString(new int[]{1,2,2,3,3,5})
                ,Arrays.toString(bubbleSort2(new int[]{1,2,3,5,2,3},6)));

        //方法3
        Assert.assertEquals(Arrays.toString(new int[]{1,2,2,3,3,5})
                ,Arrays.toString(bubbleSort3(new int[]{1,2,3,5,2,3},6)));

        //方法4
        Assert.assertEquals(Arrays.toString(new int[]{1,2,2,3,3,5})
                ,Arrays.toString(bubbleSort4(new int[]{1,2,3,5,2,3},6)));


        int count = 10;
        int[] array = ArrayUtil.generate(10);
        printAll(array);
        Assert.assertEquals(Arrays.toString(bubbleSort(array,count)),
                Arrays.toString(bubbleSort2(array,count)));
        Assert.assertEquals(Arrays.toString(bubbleSort3(array,count)),
                Arrays.toString(bubbleSort4(array,count)));
    }
}

//举例说明：要排序数组：int[] arr={6,3,8,2,9,1};
//
//        第一趟排序：
//        　　　　第一次排序：6和3比较，6大于3，交换位置：  3  6  8  2  9  1
//        　　　　第二次排序：6和8比较，6小于8，不交换位置：3  6  8  2  9  1
//        　　　　第三次排序：8和2比较，8大于2，交换位置：  3  6  2  8  9  1
//        　　　　第四次排序：8和9比较，8小于9，不交换位置：3  6  2  8  9  1
//        　　　　第五次排序：9和1比较：9大于1，交换位置：  3  6  2  8  1  9
//        　　　　第一趟总共进行了5次比较， 排序结果：      3  6  2  8  1  9
//        ---------------------------------------------------------------------
//        第二趟排序：
//        　　　　第一次排序：3和6比较，3小于6，不交换位置：3  6  2  8  1  9
//        　　　　第二次排序：6和2比较，6大于2，交换位置：  3  2  6  8  1  9
//        　　　　第三次排序：6和8比较，6大于8，不交换位置：3  2  6  8  1  9
//        　　　　第四次排序：8和1比较，8大于1，交换位置：  3  2  6  1  8  9
//        　　　　第二趟总共进行了4次比较， 排序结果：      3  2  6  1  8  9
//        ---------------------------------------------------------------------
//        第三趟排序：
//        　　　　第一次排序：3和2比较，3大于2，交换位置：  2  3  6  1  8  9
//        　　　　第二次排序：3和6比较，3小于6，不交换位置：2  3  6  1  8  9
//        　　　　第三次排序：6和1比较，6大于1，交换位置：  2  3  1  6  8  9
//        　　　　第二趟总共进行了3次比较， 排序结果：         2  3  1  6  8  9
//        ---------------------------------------------------------------------
//        第四趟排序：
//        　　　　第一次排序：2和3比较，2小于3，不交换位置：2  3  1  6  8  9
//        　　　　第二次排序：3和1比较，3大于1，交换位置：  2  1  3  6  8  9
//        　　　　第二趟总共进行了2次比较， 排序结果：        2  1  3  6  8  9
//        ---------------------------------------------------------------------
//        第五趟排序：
//        　　　　第一次排序：2和1比较，2大于1，交换位置：  1  2  3  6  8  9
//        　　　　第二趟总共进行了1次比较， 排序结果：  1  2  3  6  8  9
