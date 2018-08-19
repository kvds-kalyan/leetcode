import java.util.Arrays;
import java.util.stream.IntStream;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int fullSum = IntStream.range(1,n).sum();
        int arraySum = Arrays.stream(nums).sum();
        return arraySum-fullSum;
    }
}
