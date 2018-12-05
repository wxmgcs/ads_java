package cn.diyai.array;

import org.junit.Test;

/**
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 Output: [[1,0,0],[0,1,0],[1,1,1]]
 Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlippingAnImage {

    //RunTime 6 ms
    //先逆置行，然后取反
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0 ;i < A.length;i++){
            int min = 0;
            int max = A[i].length -1;
            int temp;

            while(min < max){
                //先逆置
                temp = A[i][min];
                A[i][min] = A[i][max];
                A[i][max] = temp;

                min++;
                max--;
            }

            //再取反
            for(int j = 0 ; j < A[i].length;j++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    @Test
    public void test(){
        int[][] A;
        int[][] B;
        A = new int[][] {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        //期望值: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
        B = flipAndInvertImage(A);
        ArrayUtil.printArrays(B);

        A = new int[][] {{1,1,0},{1,0,1},{0,0,0}};
        //
        //期望值: [[1,0,0],[0,1,0],[1,1,1]]
        B = flipAndInvertImage(A);
        ArrayUtil.printArrays(B);

        A = new int[][] {};
        //期望值: [][]
        B = flipAndInvertImage(A);
        ArrayUtil.printArrays(B);
    }
}
