import java.util.stream.IntStream;

public class MinimumASCIIDeletedSum {

    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m==0 && n==0)
            return 0;

        int dp[][] = new int[m+1][n+1];
        dp[m][n] = 0;

        for(int i=m-1;i>=0;i--) {
            dp[i][n] = dp[i+1][n]+(int) s1.charAt(i);
        }

        for(int i=n-1;i>=0;i--) {
            dp[m][i] = dp[m][i+1]+(int) s2.charAt(i);
        }


        for(int i=m-1;i>=0;i--) {
            char outer = s1.charAt(i);
            for(int j=n-1;j>=0;j--) {
                char inner = s2.charAt(j);
                if(outer==inner)
                    dp[i][j] = dp[i+1][j+1];
                else
                    dp[i][j] = Math.min(dp[i+1][j]+(int)s1.charAt(i),dp[i][j+1]+(int)s2.charAt(j));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete",""));
    }
}
