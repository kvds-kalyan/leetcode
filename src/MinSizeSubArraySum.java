public class MinSizeSubArraySum {
//Proudest algo of mine

    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int j=0;
        int from=0,to=0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            if(sum>=s) {
                while(j<=i) {
                    sum = sum-nums[j];
                    if(sum<s)
                        break;
                    j++;
                }
                if(min > i-j+1) {
                    from = j;
                    to = i;
                    min = i-j+1;
                }
                j++;
            }
        }

        return min==Integer.MAX_VALUE?0:min;

    }

    public static void main(String[] args) {
        int nums[] = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(213,nums));
    }
}
