public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        if(n==0)
            return 0;

        boolean[] reached = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++) {
            if(!reached[i]) {
                count++;
                outreach(M,reached,i);
            }
        }
        return count;
    }

    public void outreach(int[][] M, boolean[] reached,int i) {
        if(reached[i])
            return;
        int n = M.length;
        reached[i] = true;
        for(int j=0;j<n;j++) {
            if(M[i][j]==1)
                outreach(M,reached,j);
        }
    }
}
