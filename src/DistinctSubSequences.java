public class DistinctSubSequences {
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];

        for(int i=n-1;i>=0;i--) {
            dp[m-1][i] = s.charAt(m-1)==t.charAt(i)?1:0;
        }

        for(int i=m-2;i>=0;i--) {
            if(s.charAt(i)==s.charAt(n-1)) {
                dp[i][n-1] = dp[i+1][n-1]+1;
            } else {
                dp[i][n-1] = dp[i+1][n-1];
            }
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=m-2;j>=0;j--) {
                if(s.charAt(j)==t.charAt(i)) {
                    dp[j][i] = dp[j+1][i]+dp[j][i+1];
                } else {
                    dp[j][i] = dp[j+1][i];
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit","rabbit"));
    }

}
