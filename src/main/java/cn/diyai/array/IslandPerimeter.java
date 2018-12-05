package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                }

                if (j == 0 || grid[i][j - 1] == 0) {
                    ++res;
                }

                if (i == 0 || grid[i - 1][j] == 0) {
                    ++res;
                }

                if (j == n - 1 || grid[i][j + 1] == 0) {
                    ++res;
                }

                if (i == m - 1 || grid[i + 1][j] == 0) {
                    ++res;
                }
            }
        }
        return res;
    }

    //优化
    public int islandPerimeter2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int perim = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perim++;
                    }

                    if (i == m - 1 || grid[i + 1][j] == 0) {
                        perim++;
                    }

                    if (j == 0 || grid[i][j - 1] == 0) {
                        perim++;
                    }

                    if (j == n - 1 || grid[i][j + 1] == 0) {
                        perim++;
                    }

                }
            }
        }
        return perim;
    }

    @Test
    public void test() {

        Assert.assertEquals(16, islandPerimeter(new int[][]
                {
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
                }));

        Assert.assertEquals(16, islandPerimeter2(new int[][]
                {
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
                }));
    }
}
