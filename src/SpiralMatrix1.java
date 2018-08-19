import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;


        // Edge Case
        if (m==0 && n==0) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                ans.add(matrix[rowStart][i]);
            }
            rowStart ++;

            for (int i = rowStart; i <= rowEnd; i ++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd --;

            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    ans.add(matrix[rowEnd][i]);
            }
            rowEnd --;

            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    ans.add(matrix[i][colStart] );
            }
            colStart ++;
        }

        return ans;

    }
}
