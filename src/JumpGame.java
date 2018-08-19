public class JumpGame {

    public boolean canJump(int[] nums) {

        if(nums.length==0) return false;
        if(nums.length==1) return true;

        boolean dp[] = new boolean[nums.length];
        dp[nums.length-1] = true;

        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i]==0) {dp[i] = false;}
            else {
                dp[i] = false;
                for(int j=1;j<=nums[i] && i+j<nums.length;j++) {
                    dp[i] = dp[i] || dp[i+j];
                }
            }
        }

        return dp[0];

    }
}
