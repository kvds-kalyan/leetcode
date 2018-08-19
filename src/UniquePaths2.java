public class UniquePaths2 {

    //O(m*n and O(1)

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;

        if (m == 0 && n == 0)
            return 0;

        if(obstacleGrid[m-1][n-1]==1)
            return 0;

        int dp[] = new int[n];

        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 0)
                dp[i] = dp[i+1];
            else {
                dp[i] = 0;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;

                else {
                    int right = 0;
                    if (j + 1 < n)
                        right = dp[j + 1];

                    dp[j] = dp[j] + right;
                }

            }
        }

        return dp[0];

    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0,0,0}, {0,0,0,0,1}, {0,0,0,1,0},{0,0,1,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        //[[0,0,0,0,0],[0,0,0,0,1],[0,0,0,1,0],[0,0,1,0,0]]
    }

}
