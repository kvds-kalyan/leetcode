import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        int m = pairs.length;
        if (m <= 1)
            return 1;

        List<Interval> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            list.add(new Interval(pairs[i][0], pairs[i][1]));
        }

        list.sort((i1, i2) -> {
            return i1.start - i2.start;
        });

        int dp[] = new int[list.size()];
        Arrays.fill(dp, 1);

        for (int i = list.size() - 1; i >= 0; i--) {
            Interval curr = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Interval innerCurr = list.get(j);
                dp[i] = Math.max(dp[i], curr.end<innerCurr.start?dp[j] + 1:dp[j]);

            }
        }

        return dp[0];

    }
}
