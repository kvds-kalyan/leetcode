import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    /*
    Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */
    public static int[] productExceptSelf(int[] nums) {
        //first accumulate left
        int n = nums.length;
        int res[] = new int[n];

        int left = 1;
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }

        //accumulate right
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        Arrays.stream(productExceptSelf(arr)).forEach(n -> System.out.println(n));
    }
}
