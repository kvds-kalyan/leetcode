import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringKRepeated {

    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);
            if(counter.containsKey(c)){
                counter.put(c, counter.get(c)+1);
            }else{
                counter.put(c, 1);
            }

        }

        HashSet<Character> splitSet = new HashSet<Character>();
        for(char c: counter.keySet()){
            if(counter.get(c)<k){
                splitSet.add(c);
            }
        }

        if(splitSet.isEmpty()){
            return s.length();
        }

        int max = 0;
        int i=0, j=0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(splitSet.contains(c)){
                if(j!=i){
                    max = Math.max(max, longestSubstring(s.substring(i, j), k));
                }
                i=j+1;
            }
            j++;
        }

        if(i!=j)
            max = Math.max(max, longestSubstring(s.substring(i, j), k));

        return max;
    }

}
