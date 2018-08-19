public class PerfectSquares {

    //Can be done with DP obviously
    public static int numSquares(int n) {
        if(isPerfectSquare(n))
            return 1;
        int ans = n;
        for(int i=2;i*i<n;i++) {
            int withI = n/(i*i);
            int remaining = n%(i*i);
            if(remaining!=0) {
                withI+=numSquares(remaining);
                ans = Math.min(ans, withI);
            }
            ans = Math.min(ans,withI);
        }
        return ans;
    }

    public static boolean isPerfectSquare(int n) {
        double sqrt = Math.sqrt(n);
        return (sqrt-Math.floor(sqrt))==0;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
