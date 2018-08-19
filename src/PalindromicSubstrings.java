import java.util.ArrayList;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        if(n==0)
            return 0;

        boolean dp[][] = new boolean[n+1][n+1];
        int ans = 0;

        for(int i=1;i<=n;i++) {
            dp[i][i] = true;
            ans++;
        }

        for(int i=1;i<n;i++) {
            if(s.charAt(i-1)==s.charAt(i)) {
                dp[i][i+1] = true;
                ans++;
            } else {
                dp[i][i+1] = false;
            }
        }

        for(int l=3;l<=n;l++) {
            for(int j=1;j<=n-l+1;j++) {
                int k = j+l-1;
                if((s.charAt(j-1)==s.charAt(k-1)) && dp[j+1][k-1]) {
                    dp[j][k] = true;
                    ans++;
                } else {
                    dp[j][k] = false;
                }
            }
        }

        return ans;
    }
}
