public class HouseRobber2 {


        public int houseRobber2 ( int[] nums){
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }

            return Math.max(helper(nums, 0, nums.length - 2),  // the nth house is not robbed, so we break the circle in nth house.
                    helper(nums, 1, nums.length - 1)); // the nth house is robbed, so the 0th house mustn't be robbed, so we break in 0th house.
        }

        // Solution of House Robber (the simpler question)
        private int helper ( int[] nums, int lo, int hi){
            int rob = 0, notrob = 0;
            for (int i = lo; i <= hi; i++) {
                int temp = notrob;
                notrob = Math.max(notrob, rob);
                rob = temp + nums[i];
            }

            return Math.max(rob, notrob);
        }
    }