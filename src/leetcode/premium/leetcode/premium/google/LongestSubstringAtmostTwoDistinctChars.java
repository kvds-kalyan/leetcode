package leetcode.premium.leetcode.premium.google;

public class LongestSubstringAtmostTwoDistinctChars {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()<=2) {
            return s.length();
        }

        char[] sarr = s.toCharArray();

        int left = 0;
        int right;

        char c1 = sarr[0];
        char c2 = sarr[1];

        int max = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;

        for(right=1;right<sarr.length;right++) {
            if(c1==c2 && sarr[right]!=c1) {
                c2 = sarr[right];
            }
            if(c1!=c2 && sarr[right]!=c1 && sarr[right]!=c2) {
                max = Math.max(max,right-left);
                int j;
                for(j=right-1;j>left && sarr[j]==sarr[j-1];j--);
                left = j;
            }
        }


        return Math.max(max,right-left);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }

 }
