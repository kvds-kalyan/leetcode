public class MaxLengthRepeatedSubArray {

    public static int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if(m==0||n==0)
            return 0;

        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][n] = 0;
        for(int j=0;j<=n;j++)
            dp[m][j] = 0;

        int max = Integer.MIN_VALUE;
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(A[i]==B[j]) {
                    dp[i][j] = dp[i+1][j+1]+1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int A[] = {1,2,3,2,1};
        int B[] = {3,2,1,4,7};
        System.out.println(findLength(A,B));
    }
}
