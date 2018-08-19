public class PredictTheWinner {
    public static boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        if(n<=2)
            return true;

        int sum[] = new int[n];
        sum[0] = nums[0];
        for(int i=1;i<n;i++) {
            sum[i] = nums[i]+sum[i-1];
        }

        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            dp[i][i] = nums[i];
        }

        for(int l=2;l<=n;l++) {
            for(int i=0;i+l<=n;i++) {
                int j = i+l-1;
                int sumOfThisRange;
                if(i==0) {
                    sumOfThisRange = sum[j];
                } else {
                    sumOfThisRange = sum[j]-sum[i-1];
                }
                dp[i][j] = sumOfThisRange-Math.min(dp[i+1][j],dp[i][j-1]);
            }
        }

        return dp[0][n-1]>=dp[1][n-1]||dp[0][n-1]>=dp[0][n-2];

    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(predictTheWinner(nums));
    }
}
