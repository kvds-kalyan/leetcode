import java.util.ArrayList;
import java.util.List;

public class Traingle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int dp[] = new int[triangle.size()];
        List<Integer> finalrow = triangle.get(triangle.size()-1);
        for(int i=0;i<dp.length;i++) {
            dp[i] = finalrow.get(i);
        }

        for(int i=dp.length-2;i>=0;i--) {
            List<Integer> currentrow = triangle.get(i);
            for(int j=0;j<currentrow.size();j++) {
                dp[j] = Math.min(currentrow.get(j)+dp[j],currentrow.get(j)+dp[j+1]);
            }
        }

        return dp[0];

    }

    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        List<Integer> row3 = new ArrayList<>();
        List<Integer> row4 = new ArrayList<>();

        row1.add(2);

        row2.add(3);
        row2.add(4);

        row3.add(6);
        row3.add(5);
        row3.add(7);

        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);

        List<List<Integer>> ip = new ArrayList<>();

        ip.add(row1);
        ip.add(row2);
        ip.add(row3);
        ip.add(row4);


        System.out.println(minimumTotal(ip));
    }
}
