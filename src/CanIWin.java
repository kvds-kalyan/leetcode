public class CanIWin {
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        boolean dp[][] = new boolean[desiredTotal+1][maxChoosableInteger+1];
        for(int i=1;i<=desiredTotal;i++) {
            for(int j=maxChoosableInteger;j>=1;j--) {
                if(j>=i) {
                    dp[i][j] = true;
                    continue;
                }
                int total = j*(j+1)/2;
                if(total<i)
                    dp[i][j] = false;
                else {
                    dp[i][j] = !dp[i-j][j-1];
                }
            }
        }
        boolean ans = false;
        for(int i=1;i<=maxChoosableInteger;i++) {
            ans = ans||dp[desiredTotal][i];
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(canIWin(10,11));
    }
}
