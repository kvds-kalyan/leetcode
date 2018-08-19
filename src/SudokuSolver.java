import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {

        Set<Integer>[][] arr = new Set[board.length][board.length];

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                initSet(arr[i][j]);
            }
        }




    }



    public void initSet(Set<Integer> set) {
        set.addAll(IntStream.range(1,10).boxed().collect(Collectors.toList()));
    }
}
