import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static int totalNQueens(int n) {
        return solveNQueens(n).size();

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n <= 0)
            return ans;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(0, board, ans);
        return ans;

    }

    public static void helper(int row, char[][] board, List<List<String>> ans) {
        int n = board.length;
        if (row == n - 1) {
            for (int j = 0; j < n; j++) {
                board[row][j] = 'Q';
                if (validBoard(board, row, j)) {
                    List<String> newList = new ArrayList<>();
                    char[] thisRow = board[row];
                    String rowString = new String(thisRow);
                    newList.add(rowString);
                    ans.add(0, newList);
                }
                board[row][j] = '.';
            }
            return ;
        }

        List<List<String>> currList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            board[row][j] = 'Q';
            if (validBoard(board, row, j)) {
                helper(row + 1, board, ans);
                char[] thisRow = board[row];
                String rowString = new String(thisRow);
                while(!ans.isEmpty()) {
                    List<String> i1 = ans.remove(0);
                    i1.add(0,rowString);
                    currList.add(i1);
                }
            }
            board[row][j] = '.';
        }
        ans.addAll(currList);
    }

    static boolean  validBoard(char[][] board, int row, int col) {
        int n = board.length;
        //check upper left diagonal
        int k=1;
        while(row-k>=0 && col-k>=0) {
            if(board[row-k][col-k]=='Q') {
                return false;
            }
            k++;
        }
        //check upper right diagonal
        k=1;
        while(row-k>=0 && col+k<n) {
            if(board[row-k][col+k]=='Q') {
                return false;
            }
            k++;
        }
        //check up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

}



