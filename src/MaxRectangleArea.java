public class MaxRectangleArea {

    public static int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;


        int maxRight[][] = new int[m][n];
        int maxBelow[][] = new int[m][n];


        int maxArea = Integer.MIN_VALUE;

        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(j==n-1) {
                    maxRight[i][j] = 0;
                } else {
                    maxRight[i][j] = matrix[i][j+1]=='1' && matrix[i][j]=='1'?maxRight[i][j+1]+1:0;
                }

                if(i==m-1) {
                    maxBelow[i][j] =0;
                } else {
                    maxBelow[i][j] = matrix[i+1][j]=='1' && matrix[i][j]=='1'? maxBelow[i+1][j]+1:0;
                }
            }
        }

        for(int i=0;i<m-1;i++) {
            for(int j=0;j<n-1;j++) {
                int length = Math.min(maxRight[i][j],maxRight[i+1][j]);
                if(length==0) continue;
                int width = Math.min(maxBelow[i][j],maxBelow[i][j+length]);
                maxArea = Math.max(maxArea,(length+1)*(width+1));
            }
        }

        return maxArea;

    }

    public static void main(String[] args) {
        char matrix[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
