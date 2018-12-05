package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example 1:
 Input:
 [[1,1,1],
 [1,0,1],
 [1,1,1]]
 Output:
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
 Explanation:
 For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 */
public class ImageSmoother {
    /**
     * 题目给了我们一个2d M array，让我们平滑处理图片。对于每一个cell，把它更新为 以自身为中心 3x3 的平均值。
     　　就用常规方法做，新设一个 res[][] array，遍历M，对于每一个cell， 遍历以它为中心的3x3的cells，得到平均值，存入res。
     　　需要注意的就是，3x3的边界问题。
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int[][] res = new int[rows][cols];

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                int sum = 0;
                int count = 0;
                // sum 3x3 area and take care of the boundary
                for(int x=Math.max(0,i-1); x<=Math.min(rows-1, i+1); x++)
                {
                    for(int y=Math.max(0, j-1); y<=Math.min(cols-1, j+1); y++)
                    {
                        sum += M[x][y]; // sum up cells value
                        count++; // count cells number
                    }
                }

                res[i][j] = sum / count; // get average value
            }
        }

        return res;
    }

    //优化
    public int[][] imageSmoother2(int[][] M) {
        int nx = M.length;
        int ny = M[0].length;
        int[][] res = new int[nx][ny];
        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                res[i][j] = smooth(M, i, j);
            }
        }
        return res;
    }

    private int smooth(int[][] M, int x, int y) {
        int nx = M.length;
        int ny = M[0].length;
        int sum = 0;
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i < 0 || x + i >= nx || y + j < 0 || y + j >= ny) {
                    continue;
                }
                count++;
                sum += M[x + i][y + j];
            }
        }

        return sum / count;
    }

    @Test
    public void test(){

        int[][] ret =  imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        for(int i = 0; i < ret.length;i++){
            for(int j= 0;j < ret[0].length;j++){
                Assert.assertEquals(0,ret[i][j]);
            }
        }

        ret =  imageSmoother2(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        for(int i = 0; i < ret.length;i++){
            for(int j= 0;j < ret[0].length;j++){
                Assert.assertEquals(0,ret[i][j]);
            }
        }
    }
}
