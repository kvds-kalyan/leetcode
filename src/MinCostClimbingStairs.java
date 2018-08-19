public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1)
            return 0;

        int two = cost[n-1];
        int one = cost[n-2];

        if(n==2)
            return Math.min(one,two);

        for(int i=n-3;i>=0;i--) {
            int currCost = cost[i];
            int curr = currCost+Math.min(one,two);
            two = one;
            one = curr;
        }

        return Math.min(one,two);

    }

    public static void main(String[] args) {
        int cost[] = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
