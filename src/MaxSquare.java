public class MaxSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;

        int dp[][] = new int[m+1][n+1];
        int maxEdge = Integer.MIN_VALUE;

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(matrix[i-1][j-1]=='1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    maxEdge = Math.max(maxEdge,dp[i][j]);
                }
            }
        }
        return maxEdge*maxEdge;
    }
}
