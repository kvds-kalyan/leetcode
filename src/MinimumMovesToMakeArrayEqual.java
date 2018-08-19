import java.util.Arrays;

public class MinimumMovesToMakeArrayEqual {

    public int minMoves2(int[] nums) {
        if(nums.length<=1)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int equalityNum = nums[n/2];
        int moves = 0;
        for(int num : nums) {
            moves = moves+(Math.abs(equalityNum-num));
        }
        return moves;
    }
}
