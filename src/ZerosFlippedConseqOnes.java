import java.util.ArrayList;
import java.util.List;

public class ZerosFlippedConseqOnes {

    List<Integer> indicesForFlip(int[] nums,int k) {
        List<Integer> zeroPos = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                zeroPos.add(i);
            }
        }

        int max = Integer.MIN_VALUE;
        int startIndex=0,endIndex=0;

        for(int i=0;i<zeroPos.size();i++) {
            int pos = zeroPos.get(i);
            int maxFromHere = i+k-1<=zeroPos.size()-1?i+k-1:zeroPos.size()-1;

            int next = zeroPos.get(maxFromHere);
            int prev = i==0?0:zeroPos.get(i-1);

            int currMax = (pos-prev-1)+(next-pos+1);

            if(currMax > max) {
                startIndex = i;
                endIndex = maxFromHere;
                max = currMax;
            }
        }

        return zeroPos.subList(startIndex,endIndex);
    }
}
