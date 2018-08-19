public class DecodeWays {

    public static int numDecodings(String s) {
        int n = s.length();

        int last=1;
        int beforeLast=s.charAt(n-1)=='0'?0:1;

        char beforeLastChar = s.charAt(n-1);

        int curr=beforeLast;
        for(int i=n-2;i>=0;i--) {
            char currChar = s.charAt(i);
            if(currChar=='0') {
                curr = 0;
            } else {
                curr = beforeLast;
                if (isValidDuo(currChar, beforeLastChar)) {
                    curr += last;
                }
            }

            //swap numbers
            int temp = beforeLast;
            beforeLast = curr;
            last = temp;

            //swap chars
            beforeLastChar = currChar;


        }
        return curr;
    }

    private static boolean isValidDuo(char curr, char beforeLast) {
        String c = ""+curr+beforeLast;
        int ans =  c.compareTo("26");
        return ans<=0;

    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
}
