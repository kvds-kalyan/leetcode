import java.util.Arrays;

public class SearhRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0]==target?0:-1;

        int piv = findPivot(nums);

        if(target==nums[piv])
            return piv;

        int idx;

        if(target > nums[piv]) {
            idx =  Arrays.binarySearch(nums, 0, piv, target);

        } else {
            idx =  Arrays.binarySearch(nums, piv + 1, nums.length, target);
        }

        return idx<0?-1:idx;
    }

    public static int findPivot(int[] nums) {
        int lo=0;
        int hi = nums.length-1;

        while(lo<=hi) {
            if(lo==hi)
                return lo;

            int left = nums[0];

            int mid = lo + (hi-lo)/2;

            if(mid-1<lo) {
                return nums[mid+1]<nums[mid]?nums[mid+1]:nums[mid];
            }

            if(mid+1>hi) {
                return nums[mid-1]>nums[mid]?nums[mid]:nums[mid-1];
            }

            if(nums[mid-1]>nums[mid] && nums[mid+1]<nums[mid])
                return mid;

            if(nums[mid]>left) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {7,9,1,4,6};
        int target = 5;
        System.out.println(search(nums,target));
    }

}
