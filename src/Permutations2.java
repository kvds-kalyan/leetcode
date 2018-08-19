import java.util.*;

public class Permutations2 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = helper(nums,0);
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(ans);
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> helper(int[] nums,int idx) {
        if(nums.length==0)
            return new ArrayList<>();

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        if(idx==n-1) {
            List<Integer> num = new ArrayList<>();
            num.add(nums[idx]);
            ans.add(num);
            return ans;
        }

        for(int i=idx;i<n;i++) {
            swap(nums,idx,i);
            int start = nums[idx];

            List<List<Integer>> others = helper(nums,idx+1);
            others.stream().forEach(lst->lst.add(0,start));

            ans.addAll(others);
            swap(nums,idx,i);//reset
        }
        return ans;
    }

    public static void swap(int[] nums,int first,int second) {
            int temp = nums[second];
            nums[second] = nums[first];
            nums[first] = temp;
    }

    public static void main(String[] args) {
        int a[] = {2,2,1,1};
        System.out.println(permute(a));
    }
}
