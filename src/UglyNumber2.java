import java.util.PriorityQueue;

public class UglyNumber2 {
    public static int nthUglyNumber(int n) {

        if (n == 1)
            return 1;

        int dp[][] = new int[n + 1][4];
        int counter = 1;
        int curr_ugly = 1;
        int row = 1,filled_rows=1;

        dp[1][1] = curr_ugly * 2;
        dp[1][2] = curr_ugly * 3;
        dp[1][3] = curr_ugly * 5;

        while (counter != n) {
            for (int i = 1; i <=3; i++) {
                curr_ugly = dp[row][i];
                counter++;
                if (counter == n)
                    return curr_ugly;

                dp[filled_rows + i][1] = curr_ugly * 2;
                dp[filled_rows + i][2] = curr_ugly * 3;
                dp[filled_rows + i][3] = curr_ugly * 5;
            }

            row++;
            filled_rows+=3;

        }

        return curr_ugly;

    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public int nthUglyNumberPQ(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1l);

        for(long i=1; i<n; i++) {
            long tmp = q.poll();
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

            q.add(tmp*2);
            q.add(tmp*3);
            q.add(tmp*5);
        }
        return q.poll().intValue();
    }
}
