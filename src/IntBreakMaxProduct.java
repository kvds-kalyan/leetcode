public class IntBreakMaxProduct {

    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3;i<=n;i++) {
            int curr_max = Integer.MIN_VALUE;
            for(int j=2;j<i;j++) {
                int repetetion = 1;
                while(i-j*repetetion >= 0) {
                    curr_max = Math.max(curr_max, j*repetetion * dp[i - j*repetetion]);
                    repetetion++;
                }
            }
            dp[i] = curr_max;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(3));
    }

    /*
    public int integerBreak(int n) {
    int[] dp = new int[n+1];

    for(int i=1; i<n; i++){
        for(int j=1; j<i+1; j++){
            if(i+j<=n){
                dp[i+j]=Math.max(Math.max(dp[i],i)*Math.max(dp[j],j), dp[i+j]);
            }
        }
    }

    return dp[n];
}
     */

}
