public class RangeSumQuery2D {

    public static void main(String[] args) {
        int matrix[][] = {{-4,-5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(0,0,0,1));
    }
}

class NumMatrix {

    int sum[][];
    int m;

    public NumMatrix(int[][] matrix) {
        initSumMatrix(matrix);
    }

    private void initSumMatrix(int[][] matrix) {
        int m = matrix.length;
        this.m = m;
        if(m==0)
            return;
        int n = matrix[0].length;

        sum = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int currElt = matrix[i][j];
                int top=0,left=0,diagonal=0;
                if(i-1>=0)
                    top = sum[i-1][j];
                if(j-1>=0)
                    left = sum[i][j-1];
                if(i-1>=0 && j-1>=0)
                    diagonal = sum[i-1][j-1];
                sum[i][j] = currElt+top+left-diagonal;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(m==0)
            return 0;
        int currElt = sum[row2][col2];

        int top=0,left=0,diagonal=0;
        if(row1-1>=0)
            top = sum[row1-1][col2];
        if(col1-1>=0)
            left = sum[row2][col1-1];
        if (row1-1>=0 && col1-1>=0)
            diagonal = sum[row1-1][col1-1];
        return currElt-top-left+diagonal;

    }
}
