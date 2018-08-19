import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioning2 {

    public static int minCut(String s) {
        int n = s.length();
        if(n==0)
            return Integer.MAX_VALUE;

        boolean dp[][] = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++) {
            dp[i][i] = true;
        }

        for(int i=1;i<n;i++) {
            dp[i][i+1] = s.charAt(i-1)==s.charAt(i);
        }

        for(int l=3;l<=n;l++) {
            for(int j=1;j<=n-l+1;j++) {
                int k = j+l-1;
                dp[j][k] = (s.charAt(j-1)==s.charAt(k-1)) && dp[j+1][k-1];
            }
        }

        Map<Integer,Integer> cache = new HashMap<>();
        cache.put(n,0);

        for(int i=n-1;i>=1;i--) {
            int localMin = Integer.MAX_VALUE;
            for(int j=i;j<=n;j++) {
                if(dp[i][j]) {
                    if(j==n) {
                        localMin = 0;
                        continue;
                    }
                    Integer minRemaining = cache.get(j+1);
                    if(minRemaining==Integer.MAX_VALUE)
                        continue;;
                    localMin = Math.min(localMin,minRemaining+1);
                }
            }
            cache.put(i,localMin);
        }
        return cache.getOrDefault(1,Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        System.out.println(minCut("ababababababababababababcbabababababababababababa"));
    }
}
