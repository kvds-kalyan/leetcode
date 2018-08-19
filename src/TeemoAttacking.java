public class TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if(n==0)
            return 0;
        int ans = 0;
        int sufferingPoint = timeSeries[0]+duration;
        for(int i=1;i<n;i++) {
            if(timeSeries[i]>=sufferingPoint) {
                //complete suffering
                ans+=duration;
            } else {
                int sufferingDuration = timeSeries[i]-timeSeries[i-1];
                ans+=sufferingDuration;
            }
            sufferingPoint = timeSeries[i]+duration;
        }
        return ans+duration;
    }

    public static void main(String[] args) {
        int ts[] = {1,4};
        System.out.println(findPoisonedDuration(ts,2));
    }
}
