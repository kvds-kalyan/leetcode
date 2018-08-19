public class WordSearch {

    public boolean exist(char[][] board, String word) {

        char[] ch = word.toCharArray();

        int m = board.length;
        int n = board[0].length;

        int index = 0;
        boolean ans = false;

        for(int i=0;i<m && !ans;i++) {
            for(int j=0;j<n && !ans;j++) {
                if(board[i][j]==ch[0]) {
                    ans = helper(board,ch,i,j,1);
                }
            }
        }

        return ans;


    }

    public boolean helper(char[][] board,char[] ch,int i,int j,int index) {
        boolean ans = false;
        if(index==ch.length)
            return ans;
        if(index==ch.length-1 && board[i][j]==ch[index]) {
                return true;
        }

        int m = board.length;
        int n = board[0].length;


        if(board[i][j] == ch[index]) {
            char temp = board[i][j];
            board[i][j] = '#';
            //left
            if (j - 1 >= 0 && !ans) {
                ans = helper(board, ch, i, j - 1, index + 1);
            }

            //right
            if (j + 1 < n && !ans) {
                ans = helper(board, ch, i, j + 1, index + 1);
            }

            //top
            if (i - 1 >= 0 && !ans) {
                ans = helper(board, ch, i - 1, j, index + 1);
            }

            //bottom
            if (i + 1 < m && !ans) {
                ans = helper(board, ch, i + 1, j, index + 1);
            }
            board[i][j] = temp;
        }
        return ans;
    }
}
