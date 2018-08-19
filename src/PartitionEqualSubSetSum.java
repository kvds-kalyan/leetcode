import java.util.Arrays;

public class PartitionEqualSubSetSum {

    public static boolean canPartitionRecursive(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        return helper(nums, sum / 2 - nums[0], 1,sum/2-nums[0]);
    }

    private static boolean helper(int[] nums, int ongoingSum, int idx,int target) {
        if (ongoingSum == 0)
            return true;
        int n = nums.length;
        if (ongoingSum<0||idx >= n)
            return false;
        if(nums[idx]==target)
            return true;

        //this idx can or cannot belong to nums[0] gang
        return helper(nums,ongoingSum-nums[idx],idx+1,target)||helper(nums,ongoingSum,idx+1,target);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
        int nums1[] = {1,2,3,5};
        System.out.println(canPartitionRecursive(nums));
    }
}
