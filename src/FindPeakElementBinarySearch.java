public class FindPeakElementBinarySearch {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return 0;

        return helper(nums,0,n-1);

    }

    public static int helper(int[] nums,int l,int r) {
        if(l==r) {
            return l;
        }

        int mid = l+(r-l)/2;

        int mid_val = nums[mid];
        int atu = mid>0?nums[mid-1]:Integer.MIN_VALUE;
        int itu = nums[mid+1];

        if(atu<mid_val && itu<mid_val)
            return mid;
        if(mid_val>itu)
            return helper(nums,l,mid-1);
        return helper(nums,mid+1,r);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
}
