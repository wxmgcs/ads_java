package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Example 1:

 Input:
 matrix = [
 [1,2,3,4],
 [5,1,2,3],
 [9,5,1,2]
 ]
 Output: True
 Explanation:
 In the above grid, the diagonals are:
 "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 In each diagonal all elements are the same, so the answer is True.
 Example 2:

 Input:
 matrix = [
 [1,2],
 [2,2]
 ]
 Output: False
 Explanation:
 The diagonal "[1, 2]" has different elements.

 */
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length-1;i++){
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]){
                    return false;
                }
            }
        }
        return true;
    }


    //优化后
    //思路: 是方法1的逆向思维
    public boolean isToeplitzMatrix2(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }

        }
        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(true,isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));

        Assert.assertEquals(false,isToeplitzMatrix(new int[][]{{1,2},{2,2}}));

        Assert.assertEquals(true,isToeplitzMatrix2(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));

        Assert.assertEquals(false,isToeplitzMatrix2(new int[][]{{1,2},{2,2}}));
    }



}
