import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if(n<k || k<=0)
            return false;
        int sum = Arrays.stream(nums).sum();
        if(sum%k!=0)
            return false;
        boolean visited[] = new boolean[n];
        return helper(nums,visited,0,0,k,sum/k,0);
    }

    private static boolean helper(int[] nums, boolean[] visited, int start, int curr_sum, int k,int target,int curr_num) {
        if(k==1)
            return true;
        if(curr_sum==target && curr_num>0)
            return helper(nums,visited,0,0,k-1,target,0);
        for(int i=start;i<nums.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                if (helper(nums, visited, i + 1, curr_sum + nums[i], k, target, curr_num++)) return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3};
        System.out.println(canPartitionKSubsets(nums,15));
    }


}
