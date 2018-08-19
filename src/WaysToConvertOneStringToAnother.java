//https://www.geeksforgeeks.org/ways-transforming-one-string-removing-0-characters/

public class WaysToConvertOneStringToAnother {
    static int countTransformations(String from,String to) {
        if(from.length()<to.length())
            return 0;
        if(from.length()==0||to.length()==0)
            return 0;
        int count = 0;

        if(to.length()==1) {
            for(int i=0;i<from.length();i++) {
                if(from.charAt(i)==to.charAt(0))
                    count++;
            }
            return  count;
        }

        for(int i=0;i<from.length();i++) {
            while(i<from.length() && from.charAt(i)!=to.charAt(0))
                i++;
            if(i==from.length())
                return count;
            count+=countTransformations(from.substring(i+1),to.substring(1));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTransformations("abcccdf","abccdf"));
    }


}

/*
The idea to solve this problem is using Dynamic Programming. Construct a 2D DP matrix of m*n size, where m is size of string B and n is size of string A.
dp[i][j] gives the number of ways of transforming string A[0…j] to B[0…i].

Case 1 : dp[0][j] = 1, since placing B = “” with any substring of A would have only 1 solution which is to delete all characters in A.
Case 2 : when i > 0, dp[i][j] can be derived by two cases:
Case 2.a : if B[i] != A[j], then the solution would be to ignore the character A[j] and align substring B[0..i] with A[0..(j-1)]. Therefore, dp[i][j] = dp[i][j-1].
Case 2.b : if B[i] == A[j], then first we could have the solution in case a), but also we could match the characters B[i] and A[j] and place the rest of them (i.e. B[0..(i-1)] and A[0..(j-1)]. As a result, dp[i][j] = dp[i][j-1] + dp[i-1][j-1].
 */
