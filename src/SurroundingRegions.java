public class SurroundingRegions {

    public static void solveHorribly(char[][] board) {
        int m = board.length;
        if(m==0)
            return;

        int n = board[0].length;
        for(int i=1;i<m-1;i++) {
            for(int j=1;j<n-1;j++) {
                if(board[i][j]=='O') {
                    helper(board,i,j);
                }
            }
        }

        for(int i=1;i<m-1;i++) {
            for(int j=1;j<n-1;j++) {
                if(board[i][j]=='#') {
                    fillHashes(board,i,j);
                }
            }
        }
    }

    public static void fillHashes(char board[][],int i,int j) {
        if(board[i][j]!='#')
            return;
        fillHashes(board,i-1,j);
        fillHashes(board,i+1,j);
        fillHashes(board,i,j-1);
        fillHashes(board,i,j+1);

        board[i][j] = board[i-1][j]=='O'||board[i][j-1]=='O'||board[i+1][j]=='O'||board[i][j+1]=='O'?'O':'X';

    }

    public static boolean helper(char[][] board,int m,int n) {

        if(board[m][n]=='X'||board[m][n]=='#')
            return false;


        int rows = board.length;
        int cols = board[0].length;

        if(m==0||m==rows-1||n==0||n==cols-1)
            return board[m][n]=='O';

        //Mark this as # to prevent re-processing
        board[m][n] = '#';
        boolean ans =  helper(board,m,n-1)||helper(board,m,n+1)||helper(board,m-1,n)||helper(board,m+1,n);
        if(ans)
            board[m][n] = 'O';
        else {
            if(board[m-1][n]=='#'||board[m][n-1]=='#'||board[m+1][n]=='#'||board[m][n+1]=='#')
                board[m][n] = '#';
            else {
                board[m][n] = 'X';
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'}};

    }


    //Inspired from https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            boundaryDFS(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            boundaryDFS(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            boundaryDFS(board, i, j+1);
    }

}
