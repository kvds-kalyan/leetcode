public class NumberOfIslands {
    public static int numIslands(char[][] grid) {

        int m = grid.length;
        if(m==0)
            return 0;
        int n = grid[0].length;
        int max = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1') {
                    diluteConnectedLand(i,j,grid);
                    max++;
                }

            }
        }
        return max;

    }

    private static void diluteConnectedLand(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dilute yourself
        grid[i][j] = '0';
        //left check
        if(j-1>=0 && grid[i][j-1]=='1')
            diluteConnectedLand(i,j-1,grid);
        //right check
        if(j+1<n && grid[i][j+1]=='1')
            diluteConnectedLand(i,j+1,grid);
        //top check
        if(i-1>=0 && grid[i-1][j]=='1')
            diluteConnectedLand(i-1,j,grid);
        //bottom check
        if(i+1<m && grid[i+1][j]=='1')
            diluteConnectedLand(i+1,j,grid);
    }

    public static void main(String[] args) {
        int grid[][] =  {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
    }

}
