import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(nums==null||nums.length<=3)
            return ans;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++) {
            int x = nums[i];
            for(int j=i+1;j<nums.length-2;j++) {
                int y = nums[j];

                int l = j+1;
                int r = nums.length-1;

                while(l<r) {
                    if(x+y+nums[l]+nums[r]==target) {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(x);
                        lst.add(y);
                        lst.add(nums[l]);
                        lst.add(nums[r]);

                        if(!set.contains(lst)){
                            ans.add(lst);
                            set.add(lst);
                        }
                        l++;
                        r--;
                    } else if(x+y+nums[l]+nums[r] > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return ans;

    }
}
