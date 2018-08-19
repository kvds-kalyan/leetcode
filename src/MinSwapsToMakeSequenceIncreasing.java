//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing
/*
This problem follows the pattern where we can either pick or not pick and
pick[i]/notPick[i] depends on pick[i-1] and notPick[i-1] based on various conditions.

Always start to think of 2 arrays initially in questions like this.We can optimize to
O(1) as pick[i]/notPick[i] depends on pick[i-1] and notPick[i-1] i.e.only the prev results

Explanation to the solution:-
1.If A[i-1]>=B[i] or B[i-1]>=A[i], this means if we swap at ith position,things will be in screwed up
situation.So,we have no choice but to swap i-1th position too.So,

swap[i] = swap[i-1]+1
noSwap[i] = noSwap[i-1]

2.else,if A[i-1]>=A[i] or B[i-1]>=B[i], this means current situation if screwed up. Note that condition 1 and condition 2
can't happen simultaneously because it is guaranteed that a solution exists

So,as current situation is screwed up,we have to swap current indices and NOT swap prev ones,or prev one and NOT
current one , because shifting both would just mean shifting the screw up to other array

swap[i] = noSwap[i-1]+1
noSwap[i] = swap[i-1]

3.All is well.So,lets take the min of both and update
shift[i] = min(shift[i-1],noShift[i-1])+1
noShift[i] = min(shift[i-1],noShift[i-1])
 */

public class MinSwapsToMakeSequenceIncreasing {

    public static int minSwap(int[] A, int[] B) {
        int n = A.length;

        int swap[] = new int[n];
        int noSwap[] = new int[n];

        swap[0] = 1;
        noSwap[0] = 0;

        for(int i=1;i<n;i++) {
            if(A[i-1]>=B[i] || B[i-1]>=A[i]) {
                swap[i] = swap[i-1]+1;
                noSwap[i] = noSwap[i-1];
            } else if(A[i-1]>=A[i]||B[i-1]>=B[i]) {
                swap[i] = noSwap[i-1]+1;
                noSwap[i] = swap[i-1];
            } else {
                int min = Math.min(swap[i-1],noSwap[i-1]);
                swap[i] = min+1;
                noSwap[i] = min;
            }
        }
        return Math.min(swap[n-1],noSwap[n-1]);
    }

    public static void main(String[] args) {
        int A[] = {1,3,5,4};
        int B[] = {1,2,3,7};

        System.out.println(minSwap(A,B));
    }
}
