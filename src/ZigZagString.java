public class ZigZagString {
    public static String convert(String s, int numRows) {

        String[] arr = new String[numRows + 1];
        for(int j=1;j<=numRows;j++) {
            arr[j] = "";
        }
        boolean ascending = true;
        int state = 1;int i=0;
        while(i<s.length()) {
            if (ascending) {
                while (state <= numRows && i<s.length()) {
                    arr[state] = arr[state].concat(Character.toString(s.charAt(i)));
                    state++;i++;
                }
                ascending = false;
                state = numRows-1;
            } else {
                while(state>=1 && i<s.length()) {
                    arr[state] = arr[state].concat(Character.toString(s.charAt(i)));
                    state--;i++;
                }
                ascending = true;
                state=2;
            }

        }
        String result = "";
        for(int j=1;j<=numRows;j++) {
            result = result.concat(arr[j]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
