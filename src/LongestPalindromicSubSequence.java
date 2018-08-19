public class LongestPalindromicSubSequence {

    //All subsequence questions form this template. For each j from i+1 to n
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    //O(n) attempt.As we just have to remember i+1 to j
    public static int longestPalindromeSubseqLinearSpace(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int dp[] = new int[n];
        int newdp[] = new int[n];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                max = 2;
                break;
            }
        }

        dp[0] = 1;


        for (int i = n - 3; i >= 0; i--) {
            int idx = 1;
            newdp[0] = 1;
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    newdp[idx] = dp[idx - 1] + 2;
                    max = Math.max(max, newdp[idx]);
                } else {
                    newdp[idx] = 0;
                }
                idx++;
            }
            dp = newdp;
            newdp = new int[n];
        }

        return max == Integer.MAX_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}

/*

 */
