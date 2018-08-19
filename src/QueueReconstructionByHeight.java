import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        if (n == 0)
            return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];

                return o2[0] - o1[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ans.add(people[i][1],new int[]{people[i][0],people[i][1]});
        }

        int[][] ret = new int[n][2];
        int idx = 0;
        for(int[] p : ans) {
            ret[idx][0] = p[0];
            ret[idx][1] = p[1];
            idx++;
        }

        return ret;


    }

    public static void main(String[] args) {
        int people[][] = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ans = reconstructQueue(people);
        Arrays.stream(ans).forEach(ints -> System.out.println(ints[0]+"_"+ints[1]));
    }
}
