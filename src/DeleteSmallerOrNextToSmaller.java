/*
https://www.geeksforgeeks.org/delete-array-elements-which-are-smaller-than-next-or-become-smaller/
Using stack
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeleteSmallerOrNextToSmaller {
    public List<Integer> ans(int arr[],int k) {
        List<Integer> res = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        int i;
        for(i=1;i<arr.length;i++) {
            if(arr[i]<arr[i-1]) {
                st.push(i);
            }
            else {
                while(!st.isEmpty() && arr[st.peek()]<arr[i] && k>0) {
                    st.pop();
                    k--;
                }
                if(k==0) {
                    break;
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()) {
            res.add(arr[st.pop()]);
        }

        while(i<arr.length) {
            res.add(arr[i++]);
        }

        return res;
    }
}
