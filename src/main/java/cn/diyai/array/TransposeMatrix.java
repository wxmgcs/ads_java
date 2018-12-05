package cn.diyai.array;

import org.junit.Test;

public class TransposeMatrix {

    public int[][] transpose(int[][] A) {

        int [][] b =  new int[A[0].length][A.length];
        for(int i = 0 ; i < A.length;i++){
            for(int j = 0 ; j < A[0].length;j++){
                b[j][i] = A[i][j];
            }
        }
        return b;
    }


    @Test
    public void test(){

        int[][] a = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        ArrayUtil.printArrays(transpose(a));

        a = new int[][] {{1,2,3},{4,5,6}};
        ArrayUtil.printArrays(transpose(a));

    }
}
