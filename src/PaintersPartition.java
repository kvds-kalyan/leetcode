//https://www.geeksforgeeks.org/painters-partition-problem/

public class PaintersPartition {
    public int partition(int arr[],int n,int k) {
        int dp[][] = new int[n+1][k+1];
        dp[1][1] = arr[0];

        for(int i=2;i<=n;i++) {
            dp[i][1] = dp[i-1][1]+arr[i-1];
        }

        for(int i=2;i<=k;i++) {
            for(int j=2;j<=n;j++) {
                int best = Integer.MAX_VALUE;
                for(int sep=1;sep<j;sep++) {
                    best = Math.min(best,dp[sep][i-1] + sum(arr,sep,j-1));
                }
                dp[j][i] = best;
            }
        }

        return dp[n][k];

    }

    int sum(int arr[],int from,int to) {
        int n = arr.length;
        if(from<0 || from>=n || to<0 || to>=n ) {
            return 0;
        }
        if(from==to) {
            return arr[from];
        }
        int sum = 0;
        for(int i=from;i<=to;i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
