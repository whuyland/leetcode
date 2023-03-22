import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementInASortedMatrixHeap {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> vals = new PriorityQueue<>((a, b) -> b - a);
        for (int[] row : matrix) {
            for (int i : row) {
                vals.offer(i);
                if (vals.size() > k) {
                    vals.poll();
                }
            }
        }
        return vals.peek();
    }
}
