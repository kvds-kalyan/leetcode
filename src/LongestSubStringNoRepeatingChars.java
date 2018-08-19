import java.util.HashMap;
import java.util.Map;

public class LongestSubStringNoRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int l = 1;
        int left = 0,right=1;

        Map<Character,Integer> map = new HashMap<>();
        char arr [] = s.toCharArray();

        map.put(arr[0],0);

        while(right < arr.length) {
            Integer indexPos = map.get(arr[right]);
            if(indexPos != null && left <= indexPos) {
                l = Math.max(l,right-left);
                left = map.get(arr[right])+1;
            }
            map.put(arr[right],right);
            right++;
        }

        return Math.max(l,right-left);

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
