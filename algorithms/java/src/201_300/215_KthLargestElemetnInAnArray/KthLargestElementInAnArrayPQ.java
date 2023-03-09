import java.util.PriorityQueue;
import java.util.Random;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArrayPQ {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
