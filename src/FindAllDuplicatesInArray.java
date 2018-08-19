import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
                ans.add(index+1);
            nums[index] = -nums[index];
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    /*
    public List<Integer> findDuplicates(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
        // put nums[i] to it's right place if the right place is not already nums[i]
        while(i != nums[i]-1 && nums[i] != nums[nums[i]-1]) {
            int temp = nums[i];
            nums[i] = nums[nums[i]-1];
            nums[temp-1] = temp;
        }
    }
    List<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i < nums.length; i++) {
        if(i != nums[i]-1) result.add(nums[i]);
    }
    return result;
}
     */
}
