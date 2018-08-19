import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParantheses {

    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if(n<=1) {
            ans.add("");
            return ans;
        }

        Stack<Integer> stk = new Stack<>();

        for(int i=0;i<n;i++) {
            char curr = s.charAt(i);
            if(curr==')') {
                if(stk.isEmpty() || stk.peek()!='(') {
                    stk.push(i);
                } else {
                    //pop corresponding (
                    stk.pop();
                }
            } else if(curr=='('){
                stk.push(i);
            }
        }
        //whatever remains are unmatched chars
        return ans;

    }
}
