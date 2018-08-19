import java.util.HashMap;
import java.util.Map;

public class LongestConsecSeq {
    public int longestConsecutive(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int res=0;

        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],1);
        }

        for(int j=0;j<nums.length;j++) {
            if(!map.containsKey(nums[j]-1)) {
                int currcount = 1;
                int nxt=1;
                while(map.containsKey(nums[j]+nxt)) {
                    currcount++;
                    nxt++;
                }
                res = Math.max(res,currcount);
            }
        }

        return res;

    }
}
