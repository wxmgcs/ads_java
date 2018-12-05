package cn.diyai.sort;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Sort {

    private int[] generateArray(int len, int range) {
        if (len < 1) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }

    public boolean check(){
        int len = 10;
        int range = 10;
        int testTimes = 50000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateArray(len, range);
            //有多少个重复的字符
            int diffCharCount1 = diffCharCount(arr);
            int[] arr2 = exec(arr,arr.length);
            int diffCharCount2 = diffCharCount(arr2);
            if(diffCharCount1 != diffCharCount2){
                System.err.println("diff char count,Wrong Case:");
                printArray(arr);
                return false;
            }
            if (!isSorted(arr2)) {
                System.err.println("Wrong Case:");
                printArray(arr);
                return false;
            }
        }

        int len2 = 13;
        int range2 = 10;
        int testTimes2 = 50000;
        for (int i = 0; i < testTimes2; i++) {
            int[] arr = generateArray(len2, range2);
            int[] arr2 = exec(arr,arr.length);
            if (!isSorted(arr2)) {
                System.err.println("Wrong Case:");
                printArray(arr);
                return false;
            }
        }
        return true;
    }

    /**
     * 根据子类的arr检测
     * @param arr
     */
    public boolean check2(int[] arr){
        int diffCharCount1 = diffCharCount(arr);
        int[] arr2 = exec(arr,arr.length);
        int diffCharCount2 = diffCharCount(arr2);
        if(diffCharCount1 != diffCharCount2){
            System.err.println("diff char count,Wrong Case:");
            printArray(arr);
            return false;
        }
        if (!isSorted(arr2)) {
            System.err.println("Wrong Case:");
            printArray(arr);
            return false;
        }
        return true;
    }


    private int diffCharCount(int[] arr){
        HashMap hashMap =  new HashMap();
        for(int a: arr){
            if(!hashMap.containsKey(a)){
                hashMap.put(a,a);
            }
        }
        return hashMap.size();
    }

    private boolean isExist(int[] arr,int item){
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == item){
                return true;
            }
        }
        return false;
    }

    /**
     * 是否是有序的
     * @param arr
     * @return
     */
    private static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    abstract public int[]  exec(int[] arr,int len);
}
