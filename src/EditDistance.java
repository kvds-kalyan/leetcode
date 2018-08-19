public class EditDistance {
    public static int minDistance(String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();

        if(l1==0)
            return l2;
        if(l2==0)
            return l1;

        int dp[][] = new int[l1+1][l2+1];

        for(int i=l1;i>=0;i--) {
            for(int j=l2;j>=0;j--) {
                if(i==l1)
                    dp[i][j] = l2-j;
                else if(j==l2)
                    dp[i][j] = l1-i;
                else {
                    dp[i][j] = word1.charAt(i)==word2.charAt(j)?dp[i+1][j+1]:
                            1+Math.min(Math.min(dp[i+1][j+1],dp[i][j+1]),dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    //incomplete
    public static int minDistanceLinearSpace(String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();

        if(l1==0)
            return l2;
        if(l2==0)
            return l1;

        int dp[] = new int[l2+1];


        for(int i=l1;i>=0;i--) {
            for(int j=l2;j>=0;j--) {
                if(i==l1)
                    dp[j] = l2-j;
                else if(j==l2)
                    dp[j] = l1-i;
                else {
                    dp[j] = word1.charAt(i)==word2.charAt(j)?dp[j+1]:
                            1+Math.min(Math.min(dp[j+1],dp[i]),dp[j]);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(minDistanceLinearSpace("intention","execution"));
    }
}
