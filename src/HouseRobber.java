public class HouseRobber {

    public int robExtraSpace(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        int[] rob = new int[n];
        int[] dontrob = new int[n];

        rob[0] = nums[0];
        dontrob[0] = 0;
        for(int i=1;i<n;i++) {
            rob[i] = nums[i]+dontrob[i-1];
            dontrob[i] = Math.max(rob[i-1],dontrob[i-1]);
        }
        return Math.max(rob[n-1],dontrob[n-1]);
    }

    public int robConstantSpace(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;

        int rob = nums[0];
        int dontrob = 0;
        for(int i=1;i<n;i++) {
            int tmp = dontrob;
            dontrob = Math.max(rob,dontrob);
            rob = nums[i]+tmp;
        }
        return Math.max(rob,dontrob);
    }
}
