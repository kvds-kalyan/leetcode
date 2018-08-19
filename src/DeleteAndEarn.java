import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        final Map<Integer, Integer> values = new TreeMap<>();
        for (final int num : nums) {
            values.put(num, values.getOrDefault(num, 0) + num);
        }
        int pre = 0, cur = 0;
        for (final int num : values.keySet()) {
            if (!values.containsKey(num - 1)) {
                pre = cur;
                cur += values.get(num);
            } else {
                final int temp = Math.max(pre + values.get(num), cur);
                pre = cur;
                cur = temp;
            }
        }
        return cur;
    }
}
