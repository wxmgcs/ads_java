package cn.diyai.array;

import org.junit.Test;

//重构矩阵
public class ReshapeMatrix {

    int[][] nums;

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if((nums.length * nums[0].length) % (r* c)  != 0){
            return nums;
        }

        int[][] ret =  new int[r][c];
        int a = 0;
        int b = 0;
        for(int i = 0 ; i < nums.length;i++){
            for(int j = 0; j < nums[0].length;j++){
                ret[a][b] =  nums[i][j];
                b++;

                if(b >= c){
                    a++;
                    b = 0;
                }
            }
        }

        return ret;
    }

    @Test
    public void test(){
        nums = new int[][]{{1,2},{3,4}};
        nums = matrixReshape(nums,1,4);
        ArrayUtil.printArrays(nums);

        nums = new int[][]{{1,2},{3,4}};
        nums = matrixReshape(nums,4,1);
        ArrayUtil.printArrays(nums);

        nums = new int[][]{{1,2},{3,4}};
        nums = matrixReshape(nums,2,4);
        ArrayUtil.printArrays(nums);


    }
}
