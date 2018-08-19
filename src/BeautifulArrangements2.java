import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangements2 {
    public static int[] constructArray(int n, int k) {
        Set<Integer> set = new HashSet<>();

        int[] ans = new int[n];
        int num = 1;

        for(int i=0;i<n;i++) {
            ans[i] = num;
            num++;
        }

        return helper(ans,set,0,k)?ans:new int[0];

    }

    public static boolean helper(int[] ans,Set<Integer> set,int index,int k) {
        int n = ans.length;
        if(index==n-1) {
            return set.size()==k;
        }

        for(int i=index;i<n;i++) {
            swap(ans,index,i);
            int diff = Math.abs(ans[index]-ans[index+1]);
            boolean containsDiffAlready = set.contains(diff);
            set.add(diff);
            if(helper(ans,set,index+1,k)) {
                return true;
            }

            if(!containsDiffAlready) {
                set.remove(diff);
            }
            swap(ans,index,i);
        }

        return false;

    }

    public static void swap(int[] nums,int first,int second) {
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }

    public static void main(String[] args) {
        int[] ans = constructArray(5,4);
        for(int i:ans) {
            System.out.print(i+" ");
        }
    }
}
