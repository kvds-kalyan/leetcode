public class DeleteOperationForTwoStrings {
    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if(m==0 && n==0)
            return 0;

        int dp[][] = new int[m+1][n+1];//since we only need i+1's row,we can optimize this to O(n) solution
        dp[m][n] = 0;

        for(int i=m-1;i>=0;i--) {
            dp[i][n] = dp[i+1][n]+1;
        }

        for(int i=n-1;i>=0;i--) {
            dp[m][i] = dp[m][i+1]+1;
        }


        for(int i=m-1;i>=0;i--) {
            char outer = word1.charAt(i);
            for(int j=n-1;j>=0;j--) {
                char inner = word2.charAt(j);
                if(outer==inner)
                    dp[i][j] = dp[i+1][j+1];
                else
                    dp[i][j] = Math.min(dp[i+1][j]+1,dp[i][j+1]+1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
    }
}
