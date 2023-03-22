import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementInASortedMatrixMerge {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        int val = 0;
        for (int i = 0; i < k; ++i) {
            int[] row = pq.poll();
            val = row[0];
            if (row[2] + 1 < n) {
                pq.offer(new int[]{matrix[row[1]][row[2] + 1], row[1], row[2] + 1});
            }
        }
        return val;
    }
}
