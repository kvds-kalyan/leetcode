import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int currSum = Arrays.stream(nums).sum();
        return sum-currSum;
    }
}
