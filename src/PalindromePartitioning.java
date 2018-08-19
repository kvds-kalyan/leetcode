import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        int n = s.length();
        if(n==0)
            return new ArrayList<>();

        boolean dp[][] = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++) {
            dp[i][i] = true;
        }

        for(int i=1;i<n;i++) {
            dp[i][i+1] = s.charAt(i-1)==s.charAt(i);
        }

        for(int l=3;l<=n;l++) {
            for(int j=1;j<=n-l+1;j++) {
                int k = j+l-1;
                dp[j][k] = (s.charAt(j-1)==s.charAt(k-1)) && dp[j+1][k-1];
            }
        }

        Map<Integer,List<List<String>>> cache = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add(s.substring(n-1,n));
        List<List<String>> last = new ArrayList<>();
        last.add(list);
        cache.put(n,last);
        cache.put(n+1,new ArrayList<>());

        for(int i=n-1;i>=1;i--) {
            List<List<String>> curr = new ArrayList<>();
            for(int j=i;j<=n;j++) {
                if(dp[i][j]) {

                    String iToJ = s.substring(i-1,j);
                    if(j==n) {
                        List<String> untilEnd = new ArrayList<>();
                        untilEnd.add(iToJ);
                        curr.add(untilEnd);
                        continue;
                    }
                    List<List<String>> remaining = cache.get(j+1);
                    for(List<String> eachList : remaining) {
                        List<String> newList = new ArrayList<>();
                        newList.addAll(eachList);
                        newList.add(0,iToJ);
                        curr.add(newList);
                    }
                }
            }
            cache.put(i,curr);
        }
        return cache.getOrDefault(1,new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println(partition("ababababababababababababcbabababababababababababa"));
    }


}
