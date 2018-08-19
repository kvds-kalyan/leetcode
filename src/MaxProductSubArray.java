import java.util.Arrays;

public class MaxProductSubArray {

    public static int maxProductWithAtleastOnePositive(int[] nums) {
        int n = nums.length;
        int minUntilNow = 1;
        int max = 0;
        int maxUntilNow = 1;

        for(int i=0;i<n;i++) {
            if(nums[i] < 0) {
                int tmp = maxUntilNow;
                //negative has come.need to reset maxUntilNow
                maxUntilNow = Math.max(minUntilNow*nums[i],1);
                minUntilNow = Math.min(tmp*nums[i],1);
            } else if(nums[i] == 0) {
                maxUntilNow=1;
                minUntilNow=1;
            } else {
                minUntilNow = Math.min(minUntilNow*nums[i],1);
                maxUntilNow =maxUntilNow*nums[i];
            }

            if(max < maxUntilNow) {
                max = maxUntilNow;
            }
        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        int n = nums.length;

        for(int i=1;i<n;i++) {
            if(nums[i]<0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max*nums[i],nums[i]);
            min = Math.min(min*nums[i],nums[i]);
            if(res<max)
                res = max;
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,-2,1,10};
        System.out.println(maxProduct(arr));
    }
}



/*
Brilliant!!

int maxProduct(int A[], int n) {
    // store the result that is the max we have found so far
    int r = A[0];

    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
    for (int i = 1, imax = r, imin = r; i < n; i++) {
        // multiplied by a negative makes big number smaller, small number bigger
        // so we redefine the extremums by swapping them
        if (A[i] < 0)
            swap(imax, imin);

        // max/min product for the current number is either the current number itself
        // or the max/min by the previous number times the current one
        imax = max(A[i], imax * A[i]);
        imin = min(A[i], imin * A[i]);

        // the newly computed max value is a candidate for our global result
        r = max(r, imax);
    }
    return r;
}
 */

/*
Nice!
public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
 */
