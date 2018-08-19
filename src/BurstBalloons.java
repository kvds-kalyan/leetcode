public class BurstBalloons {

    public static int maxCoins(int[] nums) {

        int size = 1;
        int newarr[] = new int[nums.length+2];

        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {newarr[size++]=nums[i];}
        }

        newarr[0] = 1;newarr[size++] = 1;
        int dp[][] = new int[size][size];

        for(int i=2;i<size;i++) {
            for(int j=0;j+i<size;j++) {
               int k = j+i;
               if(i==2) {
                   dp[j][k] = newarr[j]*newarr[j+1]*newarr[j+2];
                   continue;
               }
               dp[j][k] = Integer.MIN_VALUE;
               for(int m=j+1;m<k;m++) {
                   dp[j][k] = Math.max(dp[j][k],dp[j][m]+dp[m][k]+newarr[j]*newarr[m]*newarr[k]);
               }
            }

        }

        return dp[0][size-1];
    }

    public static void main(String[] args) {
        int arr[] = {3,1,5,8};
        System.out.println(maxCoins(arr));
    }

}
