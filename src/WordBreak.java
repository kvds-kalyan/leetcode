import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Integer> map = new HashMap<>();
        wordDict.stream().forEach(str->{map.put(str,1);});
        boolean arr[] = new boolean[s.length()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = false;
        }


        for(int i=s.length()-1;i>=0;i--) {
            if(map.get(s.substring(i,s.length()))!=null) {
                arr[i] = true;
                continue;
            }
            for(int j=i+1;j<s.length();j++) {
                if(arr[j] && map.get(s.substring(i,j))!=null) {
                    arr[i] = true;
                    break;
                }
            }

        }

        return arr[0];

    }

    public static void main(String[] args) {
        String[] dict = {"leet","code"};
        System.out.println(wordBreak("leetcode", Arrays.asList(dict)));
    }
}
