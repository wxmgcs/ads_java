package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SortEvenOdd {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
     并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray(int[] array) {
        if (array.length == 0) {
            return;
        }

        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            if (val % 2 == 0) {
                evenList.add(val);
            } else {
                oddList.add(val);
            }
        }

        //将偶数加入到奇数的后面
        oddList.addAll(evenList);

        for (int i = 0; i < array.length; i++) {
            array[i] = oddList.get(i);
        }
    }

    // 排序数组,偶数在前，奇数在后
    /**
     * Input: [3,1,2,4]
     Output: [2,4,3,1]
     The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }

        //even 偶数,odd 奇数
        for(int i = 0; i < A.length/2 ; i++){
            for(int j = A.length-1;j > A.length/2;j--){
                //是偶数
                if(A[i] % 2 != 0 && A[j] % 2 == 0){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }

    //Runtime: 15 ms

    /**
     *   Input: [3,1,2,4]
         Output: [2,4,3,1]
         The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

     思路: 找连个列表分别存放奇偶数，最后合并
     * @param A
     * @return
     */
    public int[] sortArrayByParity2(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }

        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val % 2 == 0) {
                evenList.add(val);
            } else {
                oddList.add(val);
            }
        }

        //将偶数加入到奇数的后面
        evenList.addAll(oddList);

        for (int i = 0; i < A.length; i++) {
            A[i] = evenList.get(i);
        }
        return A;
    }

    //15 ms

    /**
     * 思路: 用两个指针i和j分别指向数组头和数组尾,
     * 因为偶数在前，奇数在后
     * 所以i遇到偶数
     * @param A
     * @return
     */
    public int[] sortArrayByParity3(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }

        //从前往后
        int i = 0;
        //从后往前
        int j = A.length -1;
        while(i < j){
            //如果i指向的是奇数并且j指向的是偶数就交换,且两个指针挪动一位
            if(A[i] % 2 != 0 && A[j] % 2 == 0){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i = i + 1;
                j = j - 1;

            }else{
                //如果下标i指向值是偶数，i+1
                if(A[i] % 2 == 0){
                    i = i + 1;
                }

                //如果下标j指向值是偶数，j-1
                if(A[j] % 2 != 0){
                    j = j - 1;
                }
            }
        }

        return A;
    }

    //16ms
    public int[] sortArrayByParity4(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }

        //从前往后
        int i = 0;
        //从后往前
        int j = A.length -1;
        //不同点
        while(true){
            if(i > j){
                break;
            }
            //如果i指向的是奇数并且j指向的是偶数就交换,且两个指针挪动一位
            if(A[i] % 2 != 0 && A[j] % 2 == 0){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i = i + 1;
                j = j - 1;

            }else{
                //如果下标i指向值是偶数，i+1
                if(A[i] % 2 == 0){
                    i = i + 1;
                }

                //如果下标j指向值是偶数，j-1
                if(A[j] % 2 != 0){
                    j = j - 1;
                }
            }
        }

        return A;
    }


    //用两个指针i和j,如果i指向的值不是偶数就和j指向的值交换
    //缺点: i和j指向的值不是偶数，交换没有意义
    public int[] sortArrayByParity5(int[] A) {
        int min = 0;
        int max = A.length - 1;
        int tempInt;
        while (min < max){
            if(A[min] % 2 == 0){
                min++;
            }
            else {
                tempInt = A[min];
                A[min] = A[max];
                A[max] = tempInt;
                max--;
            }
        }
        return A;
    }

    @Test
    public void testReOrderArray(){
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        reOrderArray(arr);
        Assert.assertEquals(1,arr[0]);
        Assert.assertEquals(3,arr[1]);
        Assert.assertEquals(5,arr[2]);
        Assert.assertEquals(2,arr[3]);
        Assert.assertEquals(4,arr[4]);
        reOrderArray(new int[] {});

        for(int item :sortArrayByParity(arr)){
            System.out.println(item);
        }
    }

    @Test
    public void testSortArrayByParity(){
        for(int item :sortArrayByParity(new int[] { 1, 2, 3, 4, 5 })){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity(new int[0])){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity(new int[]{3,1,2,4})){
            System.out.print(item);
        }
    }

    @Test
    public void testSortArrayByParity2(){
        for(int item :sortArrayByParity2(new int[] { 1, 2, 3, 4, 5 })){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity2(new int[0])){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity2(new int[]{3,1,2,4})){
            System.out.print(item);
        }
    }


    @Test
    public void testSortArrayByParity3(){
        for(int item :sortArrayByParity3(new int[] { 1, 2, 3, 4, 5 })){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity3(new int[0])){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity3(new int[]{3,1,2,4})){
            System.out.print(item);
        }
    }

    @Test
    public void testSortArrayByParity4(){
        for(int item :sortArrayByParity4(new int[] { 1, 2, 3, 4, 5 })){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity4(new int[0])){
            System.out.print(item);
        }

        System.out.println();

        for(int item :sortArrayByParity4(new int[]{3,1,2,4})){
            System.out.print(item);
        }
    }
}
