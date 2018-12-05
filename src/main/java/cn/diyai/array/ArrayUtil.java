package cn.diyai.array;

public class ArrayUtil {
    //打印 二维数组
    public static void printArrays(int[][] arr){
        for(int i = 0 ;i < arr.length;i++){
            for(int item: arr[i]){
                System.out.print(item+",");
            }
            System.out.println();
        }
    }
    /**
     * 打印 一维数组
     * @param arr
     */
    public static void printArray(int[] arr){
        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

    public static void printArray(int[] arr,int length){
        if(length > arr.length){
            length = arr.length;
        }

        for(int i = 0 ;i < length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

}
