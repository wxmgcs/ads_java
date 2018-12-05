package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

 Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).


 Example 1:

 Input: [[4,3,8,4],
 [9,5,1,9],
 [2,7,6,2]]
 Output: 1
 Explanation:
 The following subgrid is a 3 x 3 magic square:
 438
 951
 276
 while this one is not:
 384
 519
 762

 In total, there is only one magic square inside the given grid.
 Note:

 1 <= grid.length <= 10
 1 <= grid[0].length <= 10
 0 <= grid[i][j] <= 15
 */
public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {

        int row=grid.length,col=grid[0].length,cnt=0;

        for(int i=0;i<row-2;++i){
            for(int j=0;j<col-2;++j){
                if(islegal(i,j,grid)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

   private boolean islegal(int i,int j,int[][] grid) {
        for (int r = i; r < i + 3; ++r) {
            for (int c = j; c < j + 3; ++c) {
                if (!(grid[r][c] >= 1 && grid[r][c] <= 9)) {
                    return false;
                }
            }
        }
        int[] v = new int[8];
        v[0] = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        v[1] = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        v[2] = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        v[3] = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        v[4] = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        v[5] = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        v[6] = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        v[7] = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
        for (int k = 0; k < 7; ++k) {
            if (v[k] != v[k + 1]){
                return false;
            }

        }
        return true;
    }



    //优化后
    public int numMagicSquaresInside2(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i + 2 < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                if (passCheck(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean passCheck(int x, int y, int[][] grid) {

        // check rows;
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[x + i][y + j] > 9 || grid[x + i][y + j] < 1) {
                    return false;
                }
                rowSum += grid[x + i][y + j];
            }
            if (rowSum != 15) {
                return false;
            }
        }

        // check cols:
        for (int j = 0; j < 3; j++) {
            int colSum = 0;
            for (int i = 0; i < 3; i++) {
                if (grid[x + i][y + j] > 9 || grid[x + i][y + j] < 1) {
                    return false;
                }
                colSum += grid[x + i][y + j];
            }
            if (15 != colSum) {
                return false;
            }
        }
        // check diagonal
        int diagonalSum = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        if (diagonalSum != 15) {
            return false;
        }

        // check anti diagonal
        int antiDiagonalSum = grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2];
        if (15 != antiDiagonalSum) {
            return false;
        }
        return true;
    }

    @Test
    public void test(){
        Assert.assertEquals(1,numMagicSquaresInside(new int[][]{
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        }));

        Assert.assertEquals(1,numMagicSquaresInside2(new int[][]{
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        }));
    }
}
