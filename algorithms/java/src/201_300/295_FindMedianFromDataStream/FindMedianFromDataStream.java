import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class FindMedianFromDataStream {
    private final PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> large = new PriorityQueue<>();

    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.add(num);
            large.add(small.poll());
        } else {
            large.add(num);
            small.add(large.poll());
        }

    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return 0.5 * (small.peek() + large.peek());
        }
        return large.peek();
    }
}
