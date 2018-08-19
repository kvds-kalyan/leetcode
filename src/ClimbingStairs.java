public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n<=2)
            return n;

        int first = 1;
        int second = 2;

        for(int i=3;i<n;i++) {
            int curr = first+second;
            int tmp = second;
            second = curr;
            first = tmp;
        }

        return first+second;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
