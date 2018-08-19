public class RangeSumQuery {
}

class NumArray {

    int[] nums;
    public NumArray(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++) {
            nums[i]+=nums[i-1];
        }

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return nums[j];
        return nums[j]-nums[i-1];
    }
}
