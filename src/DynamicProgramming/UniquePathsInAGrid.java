/*
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n will be at most 100.

 */
package DynamicProgramming;

public class UniquePathsInAGrid {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] path = new int[m][n];
        path[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++)
            path[i][0] = (obstacleGrid[0][0] == 0 && path[i - 1][0] != 0
                    && obstacleGrid[i][0] == 0) ? 1 : 0;
        for (int i = 1; i < n; i++)
            path[0][i] = (obstacleGrid[0][0] == 0 && path[0][i - 1] != 0
                    && obstacleGrid[0][i] == 0) ? 1 : 0;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                path[i][j] = obstacleGrid[i][j] == 0 ? (path[i - 1][j] +
                        path[i][j - 1]) : 0;

        return path[m - 1][n - 1];

    }
}
