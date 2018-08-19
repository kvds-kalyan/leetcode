import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return helper(coins,amount,dp);
    }



    private static int helper(int[] coins, int amount, int[] dp) {
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;
        if(dp[amount]!=Integer.MAX_VALUE)
            return dp[amount];
        for(int i=0;i<coins.length;i++) {
            int ans = helper(coins,amount-coins[i],dp);
            dp[amount] = ans==-1?dp[amount]:Math.min(dp[amount],ans+1);
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper1(coins, amount, new int[amount]);
    }

    private static int helper1(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed
        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }

    public int coinChangeIteravtive(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;

        while(++sum<=amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;
                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        System.out.println(coinChange1(coins,6249));
    }
}
