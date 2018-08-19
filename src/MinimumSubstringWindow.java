import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//This problem is similar in spirit to:https://leetcode.com/problems/minimum-size-subarray-sum/
//Must read to solve substring/contiguous array problems;https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems?page=1
public class MinimumSubstringWindow {


    public static String minWindow(String s, String t) {

        Map<Character, Integer> targetCharsMap = new HashMap<>();


        for (char ch : t.toCharArray()) {
            int cntr = targetCharsMap.getOrDefault(ch, 0);
            targetCharsMap.put(ch, cntr + 1);
        }

        int minLength = Integer.MAX_VALUE;
        String ans = "";

        char[] schar = s.toCharArray();
        int n = s.length();

        int counter = t.length();
        int j = 0;

        for (int i = 0; i < n; i++) {
            char ch = schar[i];

            if (targetCharsMap.containsKey(ch)) {
                int x = targetCharsMap.get(ch);
                targetCharsMap.put(ch, x - 1);
                if (x > 0) {
                    counter--;
                }
            }

            if (counter == 0) {
                while (j <= i) {
                    char curr = schar[j];
                    if(targetCharsMap.containsKey(curr)) {
                        int x = targetCharsMap.get(curr);
                        targetCharsMap.put(curr,x+1);
                        if(x>0)
                            counter++;
                    }
                }

            }

        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(minWindow("aaabcd","ab"));
    }

    /*
     public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        int begin = 0;
        int end = 0;
        int count = t.length();
        int head = 0, tail = 0;
        int diff = Integer.MAX_VALUE;
        while (end < s.length()) {
            char e = s.charAt(end);

            if (map.merge(e, -1, Integer::sum) >= 0) { // map.merge() returns the final result
                count--;
            }
            while (count == 0) {
                char b = s.charAt(begin);

                if (diff > end-begin ) {
                    head = begin;
                    // +1 because of exclusive s.substring() call below
                    tail = end+1;
                    diff = tail - head;
                }
                if (map.merge(b, +1, Integer::sum) > 0) { // map.merge() returns the final result
                    count++;
                }
                begin++;
            }
            end++;
        }

        return s.substring(head, tail);
    }
     */
}
