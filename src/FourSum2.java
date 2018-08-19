import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        if(n==0)
            return 0;

        Map<Integer,Integer> map = new HashMap<>();
        int ans=0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int inTheMap = map.getOrDefault(A[i]+B[j],0);
                map.put(A[i]+B[j],inTheMap+1);
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int curr = -C[i]-D[j];
                ans+=map.getOrDefault(curr,0);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int A[] = {1,2};
        int B[] = {-2,-1};
        int C[] = {-1,2};
        int D[] = {0,2};

        int A1[] = {0,1,-1};
        int A2[] = {-1,1,0};
        int A3[] = {0,0,1};
        int A4[] = {-1,1,1};

        System.out.println(fourSumCount(A1,A2,A3,A4));
    }
}

/*
def fourSumCount(self, A, B, C, D):
    AB = collections.Counter(a+b for a in A for b in B)
    return sum(AB[-c-d] for c in C for d in D)
 */

/*
My solution without map

public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        if(n==0)
            return 0;

        int ans=0;

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        for(int i=0;i<n;i++) {
            int x = A[i];
            for(int j=0;j<n;j++) {
                int y = B[j];
                int hi=n-1,lo=0;
                int target = -(x+y);
                while(hi>=0 && lo<n) {
                    if(C[lo]+D[hi]==target) {
                        //handling duplicates
                        int currLo = lo;
                        int currHi = hi;
                        while(currLo+1<n && C[currLo]==C[currLo+1])
                            currLo++;

                        while(currHi-1>=0 && C[currHi]==C[currHi-1])
                            currHi--;

                        int countLo = currLo-lo;
                        countLo = currLo==n-1?countLo:countLo+1;

                        int countHi = hi-currHi;
                        countHi = currHi==0?countHi+1:countHi;

                        ans+=countHi*countLo;

                        lo = currLo;
                        hi = currHi;
;
                    } else if(C[lo]+D[hi]<target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }

        return ans;
    }
 */