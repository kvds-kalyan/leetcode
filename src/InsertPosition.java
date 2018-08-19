public class InsertPosition {

    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return 0;
        return helper(nums, 0, nums.length-1,target);

    }

    private int helper(int[] nums, int l, int r, int target) {
        if(l==r) {
            if(nums[l]<=target) {
                return l;
            } else {
                return l+1;
            }
        }

        int mid = (l+r)/2;
        if(nums[mid]==target||nums[mid]>target && mid-1>=0 && nums[mid-1]<target)
            return mid;
        if(nums[mid]>target)
            return helper(nums,l,mid,target);
        return helper(nums,mid,r,target);

    }
}

/*
public int searchInsert(int[] nums, int target) {
    int i=0;
    int j=nums.length-1;

    while(i<=j){
        int mid = (i+j)/2;

        if(target > nums[mid]){
            i=mid+1;
        }else if(target < nums[mid]){
            j=mid-1;
        }else{
            return mid;
        }
    }

    return i;
}
 */
