import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer> freq[] = new List[n+1];
        Map<Integer,Integer> freqMap = new HashMap<>();
        Arrays.stream(nums).forEach(num->freqMap.merge(num,1,(oldVal,newVal)->oldVal+newVal));
        Map<Integer,List<Integer>> reverseMapped = freqMap.entrySet().stream().collect(Collectors.groupingBy(Entry::getValue,
                Collectors.mapping(Entry::getKey,Collectors.toList())));
        reverseMapped.entrySet().stream().forEach(entry->freq[entry.getKey()]=entry.getValue());
        return IntStream.range(0,n).filter(i->freq[n-i]!=null).boxed().flatMap(i->freq[n-i].stream()).limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums,2));
    }
}
