public class MaxAreaOfIsland {
    //Using BFS
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    int currArea = findMaxArea(i,j,grid);
                    max = Math.max(max,currArea);
                }

            }
        }
        return max;
    }

    public static int findMaxArea(int i,int j,int[][] grid) {
        int ans = 1;
        int m = grid.length;
        int n = grid[0].length;
        //dilute yourself
        grid[i][j] = 0;
        //left check
        if(j-1>=0 && grid[i][j-1]==1)
            ans+=findMaxArea(i,j-1,grid);
        //right check
        if(j+1<n && grid[i][j+1]==1)
            ans+=findMaxArea(i,j+1,grid);
        //top check
        if(i-1>=0 && grid[i-1][j]==1)
            ans+=findMaxArea(i-1,j,grid);
        //bottom check
        if(i+1<m && grid[i+1][j]==1)
            ans+=findMaxArea(i+1,j,grid);

        return ans;

    }

    public static void main(String[] args) {
       int grid[][] =  {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int grid1[][] =  {{1,0,1},{1,1,1}};
        System.out.println(maxAreaOfIsland(grid1));
    }
}
