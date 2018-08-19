public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int indexS = 0,indexT=0;
        int m = s.length();
        int n = t.length();

        while(indexS<m && indexT<n) {
            if(s.charAt(indexS)==t.charAt(indexT)) {
                indexS++;
                indexT++;
            } else {
                indexT++;
            }
        }

        return indexS==m;

    }
}
