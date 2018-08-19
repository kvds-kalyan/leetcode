import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates,target,0);

    }

    public static List<List<Integer>> helper(int[] candidates,int target,int curr) {
        List<List<Integer>> res = new ArrayList<>();
        if(target < 0 || curr >= candidates.length) {
            return res;
        }
        if(target == candidates[curr]) {
            List<Integer> lst = new ArrayList<>();
            lst.add(candidates[curr]);
            res.add(lst);
            return res;
        }

        List<List<Integer>> none = helper(candidates,target,curr+1);
        List<List<Integer>> once = helper(candidates,target-candidates[curr],curr+1);
        List<List<Integer>> more = helper(candidates,target-candidates[curr],curr);



        if(once.size()!=0) {
            once.forEach(lst->lst.add(0,candidates[curr]));
        }

        if(more.size()!=0) {
            more.forEach(lst->lst.add(0,candidates[curr]));

        }

        Set<List<Integer>> set = new HashSet<>();
        set.addAll(none);
        set.addAll(once);
        set.addAll(more);

        res.addAll(set);
        //res.sort((l1,l2)->{return l1.size()<l2.size()?-1:1;});
        return res;

    }

    public static void main(String[] args) {
        int arr[] = {2,3,5};
        System.out.println(combinationSum(arr,8));
    }
}
