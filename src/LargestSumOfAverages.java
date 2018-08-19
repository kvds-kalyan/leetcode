import java.util.Arrays;

public class LargestSumOfAverages {

    //well done
    public static double largestSumOfAverages(int[] A, int K) {
        int n = A.length;

        double[][] dp = new double[n+1][K+1];

        for(int i=0;i<n;i++) {
            int divisor = n-i;
            dp[i][1] = (double)1.0*sumOfArray(A,i,n-1)/divisor;
        }

        for(int i=1;i<=K;i++) {
            dp[n][i] = 0;
        }

        for(int i=2;i<=K;i++) {
            for(int j=0;j<=n-i;j++) {
                double localMax = Double.MIN_VALUE;
                for(int k=j;k<=n-i;k++) {
                    int from = j;
                    int to = k;
                    int diff = to-from+1;
                    double average = (double)1.0*sumOfArray(A,from,to)/diff;
                    localMax = Math.max(localMax,dp[to+1][i-1]+average);
                }
                dp[j][i] = localMax;
            }
        }
        return dp[0][K];
    }

    public static int sumOfArray(int A[],int from,int to) {
        if(from==to)
            return A[from];
        else {
            int sum = 0;
            for(int i=from;i<=to;i++) {
                sum+=A[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int A[] = {9,1,2,3,9};
        int A1[] = {4,1,7,5,6,2,3};
        int K1 = 4;
        System.out.println(largestSumOfAverages(A1,K1));

    }
}
