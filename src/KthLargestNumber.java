import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNumber {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        Arrays.stream(nums).forEach(num->pq.add(num));
        for(int counter=k-1;counter>0;counter--,pq.poll());
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findKthLargest(nums,2));
    }
}
