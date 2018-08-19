public class FindRange {

    public static int[] searchRange(int[] nums, int target) {
        int left = myBinarySearch(true,nums,0,nums.length-1,target);
        int right = myBinarySearch(false,nums,0,nums.length-1,target);
        int[] res =  {left,right};
        return res;
    }



    public static int myBinarySearch(boolean isleft,int[] nums,int left,int right,int target) {
        if(right<0 || left>right) {
            return -1;
        }
        if(left==right) {
            return nums[left]==target ?left:-1;
        }
        int mid = (right-left)/2;
        if(nums[mid]>target) {
            return myBinarySearch(isleft,nums,left,mid-1,target);
        } else if(nums[mid] < target) {
            return myBinarySearch(isleft,nums,mid+1,right,target);
        } else {
            if(isleft) {
               int index = myBinarySearch(isleft,nums,left,mid-1,target) ;
               return index==-1?mid:index;
            } else {
                int index = myBinarySearch(isleft,nums,mid+1,right,target) ;
                return index==-1?mid:index;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchRange(nums,8));
    }

    /*
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
     */
}
