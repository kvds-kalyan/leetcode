import java.util.ArrayList;
import java.util.List;

//This is not back-tracking solution
public class SubSetBackTracking {

    public static List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return new ArrayList<>();
        List<List<Integer>> ans =  helper(nums,0);
        ans.add(new ArrayList<>());
        return ans;
    }

    private static List<List<Integer>> helper(int[] nums, int from) {
        if(from>=nums.length) {
            return new ArrayList<>();
        }

        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> onlyMe = new ArrayList<>();
        onlyMe.add(nums[from]);
        finalAns.add(onlyMe);

        List<List<Integer>> others = helper(nums,from+1);
        if(others.isEmpty()) {
            return finalAns;
        }

        List<List<Integer>> othersWithMe = new ArrayList<>();
        for(List<Integer> other : others) {
            List<Integer> otherWithMe = new ArrayList<>(other);
            otherWithMe.add(nums[from]);

            othersWithMe.add(otherWithMe);
        }


        finalAns.addAll(others);
        finalAns.addAll(othersWithMe);

        return finalAns;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    //https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
}
