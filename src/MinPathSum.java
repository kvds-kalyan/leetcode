//O(m) space
public class MinPathSum {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (m == 0 && n == 0)
            return 0;

        int dp[] = new int[n]; //we can use lower row as the dp array instead.That would be O(1) solution

        dp[n - 1] = grid[m-1][n-1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i]=grid[m-1][i]+dp[i+1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j + 1 < n) {
                    dp[j] = Math.min(dp[j]+grid[i][j],dp[j+1]+grid[i][j]);
                } else {
                    dp[j]+=grid[i][j];
                }

            }
        }

        return dp[0];

    }
}
