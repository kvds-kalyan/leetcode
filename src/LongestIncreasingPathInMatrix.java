public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];

        Integer max = Integer.MIN_VALUE;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!visited[i][j]) {
                    int localMax = findTheBestPathFrom(matrix,visited,dp,i,j);
                    max = Math.max(localMax,max);
                }
            }
        }
        return max;

    }

    public int findTheBestPathFrom(int[][] matrix,boolean[][] visited,int[][] dp,int i,int j) {
        if(visited[i][j])
            return dp[i][j];

        int m = matrix.length;
        int n = matrix[0].length;

        int curr = matrix[i][j];
        int l=0,r=0,u=0,d=0;
        boolean isOne = true;
        if(j-1>=0 && matrix[i][j-1]>curr)
            l = findTheBestPathFrom(matrix,visited,dp,i,j-1);isOne=false;
        if(j+1<n && matrix[i][j+1]>curr)
            r = findTheBestPathFrom(matrix,visited,dp,i,j+1);isOne=false;
        if(i-1>=0 && matrix[i-1][j]>curr)
            u = findTheBestPathFrom(matrix,visited,dp,i-1,j);isOne=false;
        if(i+1<m && matrix[i+1][j]>curr)
            d = findTheBestPathFrom(matrix,visited,dp,i+1,j);isOne=false;

        if(isOne)
            dp[i][j] = 1;
        else {
            dp[i][j] = Math.max(Math.max(l,r),Math.max(u,d))+1;
        }
        visited[i][j] = true;
        return dp[i][j];


    }
}
