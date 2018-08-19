import java.util.Stack;

public class LongestValidParanthesis {

    public  static int longestValidParentheses(String s) {
        if(s.length()<=1)
            return 0;

        char[] paran_arr = s.toCharArray();

        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<paran_arr.length;i++) {
            if(paran_arr[i]=='(')
                stack.push(i);
            else {
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int top = stack.peek();
                    if(paran_arr[top] == '(')
                        stack.pop();
                    else {
                        stack.push(i);
                    }
                }
            }
        }

        int end=paran_arr.length-1,start=0;
        while(!stack.isEmpty()) {
             start = stack.pop();
             max = Math.max(max,end-start);
             end = start-1;
        }

        return Math.max(max,end+1);

    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

}
