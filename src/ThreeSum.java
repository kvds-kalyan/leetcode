import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l,r;
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();


        for(int i=0;i<nums.length-1;i++) {
            int x = nums[i];
            l=i+1;r=nums.length-1;
            while(l<r) {
                if(x+nums[l]+nums[r]==0) {

                    List<Integer> curr = new ArrayList<>();
                    curr.add(x);
                    curr.add(nums[l]);
                    curr.add(nums[r]);

                    if(!set.contains(curr)) {
                     set.add(curr);
                     res.add(curr);
                    }

                    l++;r--;
                } else if(x+nums[l]+nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }


        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
