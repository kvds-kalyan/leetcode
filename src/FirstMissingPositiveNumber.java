import java.util.Arrays;

public class FirstMissingPositiveNumber {

    public static int firstMissingPositive(int[] nums) {

        if(nums==null||nums.length==0)
            return 1;
        int n = nums.length;
        int first_pos = partition(nums);
        int new_length = n-first_pos;

        for(int i=first_pos;i<n;i++) {
            int k = nums[i]<0?-nums[i]:nums[i];
            if(k>new_length) {
                continue;
            }
             int pos = first_pos+k-1;
             nums[pos] = nums[pos]<0 ? nums[pos]:-nums[pos];
        }
        int i;
        for(i=first_pos;i<n;i++) {
            if(nums[i]>0)
                break;
        }
        return i-first_pos+1;
    }

    public static int partition(int[] nums) {
        int ptr=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<=0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        return ptr;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,0};
        System.out.println(firstMissingPositive(arr));
    }

}

/*
int firstMissingPositive(int A[], int n)
    {
        for(int i = 0; i < n; ++ i)
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
                swap(A[i], A[A[i] - 1]);

        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;

        return n + 1;
    }
 */


