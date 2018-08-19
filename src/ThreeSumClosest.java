import java.util.*;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int l,r;

        int min = Integer.MAX_VALUE;
        int closestSum = 0;


        for(int i=0;i<nums.length-1;i++) {
            int x = nums[i];
            l=i+1;r=nums.length-1;
            while(l<r) {
                int sum = x+nums[r]+nums[l];
                int diff = sum-target;
                if(Math.abs(diff) < min) {
                    min = Math.abs(diff);
                    closestSum = sum;
                }
                if(diff<0) {l++;}
                else if(diff>0) {r--;}
                else {l++;r--;}

            }
        }

        return closestSum;

    }

    public static void main(String[] args) {

        int arr[] = {1,1,-1,-1,3};
        System.out.println(threeSumClosest(arr,-1));
    }
}
