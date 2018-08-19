public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        if(palindromeCheck(s)) {
            return s;
        }

        int n = s.length();
        char sarr[] = s.toCharArray();
        String res = "";

        int left,right,window;
        window = n/2;
        boolean window_found = false;


        while(window>0 && !window_found) {
            left = window-1;
            if(sarr[window] == sarr[window-1]) {
                right = window;
            } else {
                right = window+1;
            }

            while(left>=0 && right<n) {
                if(sarr[left]!=sarr[right]) {
                    break;
                }
                left--;
                right++;
            }
            if(left<0) {
                window_found = true;
                break;
            }
            window--;

        }


        right  = 2*window+1;
        int i=0;
        while(right<n) {
            res =sarr[right] + res;
            right++;
            i++;
        }

        return res.concat(s);

    }

    public static boolean palindromeCheck(String s) {
        char[] sarr = s.toCharArray();
        int left=0,right=s.length()-1;

        while(left<right) {
            if(sarr[left]!=sarr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }
}

/*
public String shortestPalindrome(String s) {
    int i=0;
    int j=s.length()-1;

    while(j>=0){
        if(s.charAt(i)==s.charAt(j)){
            i++;
        }
        j--;
    }

    if(i==s.length())
        return s;

    String suffix = s.substring(i);
    String prefix = new StringBuilder(suffix).reverse().toString();
    String mid = shortestPalindrome(s.substring(0, i));
    return prefix+mid+suffix;
}
 */
