import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(int i=0;i+9<n;i++) {
            String curr = s.substring(i,i+10);
            if(visited.contains(curr)) {
                ans.add(curr);
            }
            visited.add(curr);
        }
        return new ArrayList<>(ans);
    }


    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
