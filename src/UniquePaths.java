public class UniquePaths {

    public int uniquePaths(int m, int n) {

        if (m == 0 && n == 0)
            return 0;

        int dp[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int right = 0;
                if (j + 1 < n)
                    right = dp[j + 1];
                dp[j] = dp[j] + right;
            }
        }

        return dp[0];
    }
}
