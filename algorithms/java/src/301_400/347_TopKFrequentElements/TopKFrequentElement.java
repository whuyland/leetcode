import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        freq.forEach((key, val) -> pq.add(new int[]{val, key}));
        int[] ret = new int[k];
        while (k > 0) {
            ret[--k] = pq.poll()[1];
        }
        return ret;
    }
}
