import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParantheses {

    public static List<String> generateParenthesis(int n) {
        if(n==0)
            return new ArrayList<>();
        Map<Integer,List<String>> cache = new HashMap<>();
        return helper(n,cache);

    }

    private static List<String> helper(int n, Map<Integer, List<String>> cache) {
        if(cache.containsKey(n))
            return cache.get(n);

        List<String> ans = new ArrayList<>();

        for(int i=n-1;i>=0;i--) {
            List<String> temp = new ArrayList<>();
            //enclosing
            List<String> enclosing = helper(i,cache);
            if(enclosing.isEmpty()) {
                temp.add("()");
            }
            else {
                for(String enclosingRes : enclosing) {
                    String appended = "("+enclosingRes+")";
                    temp.add(appended);
                }
            }

            //non-enclosing
            List<String> nonEnclosing = helper(n-1-i,cache);
            if(nonEnclosing.isEmpty())
                ans.addAll(temp);
            for(String nonEnclosingRes : nonEnclosing) {
                for(String currAns : temp) {
                    ans.add(currAns+nonEnclosingRes);
                }
            }
        }

        cache.put(n,ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
