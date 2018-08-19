public class CheapestFlightsWithKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(n==1)
            return 0;

        int m = flights.length;

        int adj[][] = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                adj[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<m;i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];

            adj[from][to] = cost;
        }

        int dp[] = new int[n];

        for(int i=0;i<n;i++) {
            dp[i] = adj[i][dst];
        }

        int dp_new[] = new int[n];

        for(int i=1;i<=K;i++) {
            for(int j=0;j<n;j++) {
                int localMin = Integer.MAX_VALUE;
                for(int k=0;k<n;k++) {
                    if(j!=k && adj[j][k]!=Integer.MAX_VALUE && dp[k]!=Integer.MAX_VALUE) {
                        localMin = Math.min(localMin, adj[j][k] + dp[k]);
                    }
                }
                dp_new[j] = Math.min(dp[j],localMin);
            }
            dp = dp_new;
            dp_new = new int[n];
        }

        return dp[src]==Integer.MAX_VALUE?-1:dp[src];
    }

    public static void main(String[] args) {
        int flights[][] = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        System.out.println(findCheapestPrice(5,flights,0,2,2));
    }
}
