public class MaxSumSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        int max = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            nums[i] = Math.max(nums[i+1]+nums[i],nums[i]);
            max = Math.max(max,nums[i]);
        }
        return max;
    }
/*
    public int maxSubArrayDivideAndConquer(int[] nums) {

    }
    */
}
