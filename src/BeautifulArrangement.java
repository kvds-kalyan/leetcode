import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeautifulArrangement {

    public static int countArrangement(int N) {
        List<Integer> nums = IntStream.range(1,N+1).boxed().collect(Collectors.toList());
        return helper(nums,1,N);
    }

    private static int helper(List<Integer> nums,int index,int N) {
        if(index==N) {
            return areConditionsMet(nums.get(0),index)?1:0;
        }
        int ans=0;
        for(int i=0;i<nums.size();i++) {
            int curr = nums.remove(i);
            if(areConditionsMet(curr,index)) {
                ans+=helper(nums,index+1,N);
            }
            nums.add(i,curr);
        }
        return ans;
    }

    public static boolean areConditionsMet(int n,int idx) {
        return n%idx==0||idx%n==0;
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(2));
    }
}
