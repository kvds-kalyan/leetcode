import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KthPermutation {

    public static String getPermutation(int n, int k) {
        if(n==1)
            return "1";
        String ans = "";
        int r=1;
        List<Integer> nums = IntStream.range(1,n+1).boxed().collect(Collectors.toList());
        k--;
        while(ans.length()!=n) {
            int slot = k/factorial(n-r);
            k = k%factorial(n-r);
            int appendInt = nums.get(slot);
            ans = ans.concat(appendInt+"");
            nums.remove(slot);
            r++;
        }

        return ans;
    }

    static int factorial(int n)
    {
        int res = 1, i;
        for (i=2; i<=n; i++)
            res *= i;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(2,2));
    }

}

/*
No k = k-1

public String getPermutation(int n, int k) {
    List<Integer> num = new LinkedList<Integer>();
    for (int i = 1; i <= n; i++) num.add(i);
    int[] fact = new int[n];  // factorial
    fact[0] = 1;
    for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
    StringBuilder sb = new StringBuilder();
    for (int i = n; i > 0; i--) {
        if(k%fact[i-1]==0) { // we already found it
            int ind = k/fact[i-1]-1;
            sb.append(num.get(ind));
            num.remove(ind);
            Collections.reverse(num); // the final state is the reverse of rest number
            for(int d : num)
                sb.append(d);
            return sb.toString();
        } else {
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
    }
    return sb.toString();
}
 */