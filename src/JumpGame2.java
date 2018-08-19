//https://leetcode.com/problems/jump-game-ii/description/
//O(n) solution
public class JumpGame2 {

    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums.length==2)
            return 1;

        int max_index = 0;
        int steps=1;
        int n = nums.length;

        for(int i=0;i<n;i++) {
            if(i+nums[i]>=n-1) {
                break;
            }
            max_index = Math.max(max_index,i+nums[i]);
            if(i>max_index) {
                steps++;
            }
        }

        return steps+1;
    }
}

/*
if (nums == null || nums.length == 0)
		return 0;

	int lastReach = 0;
	int reach = 0;
	int step = 0;

	for (int i = 0; i <= reach && i < nums.length; i++) {
		//when last jump can not read current i, increase the step by 1
		if (i > lastReach) {
			step++;
			lastReach = reach;
		}
		//update the maximal jump
		reach = Math.max(reach, nums[i] + i);
	}

	if (reach < nums.length - 1)
		return 0;

	return step;
 */
