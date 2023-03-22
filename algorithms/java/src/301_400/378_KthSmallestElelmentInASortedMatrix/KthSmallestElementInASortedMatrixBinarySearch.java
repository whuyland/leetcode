// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementInASortedMatrixBinarySearch {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1] + 1;

        // given a value, we count the number of elements
        // that are smaller equal than the value
        // if the count is k, we know there are k values,
        // that [smallest...k-th-smallest], val, [k+1-th-smallest....largest]
        // therefore all integer in [k-th-smallest, k+1-th-smallest)
        // will have the count equals k

        // it's like find the lower bound that makes the count equals k
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2; // or to use Math.floor; negative divid round to zero
            int cnt = countSmallerEqual(matrix, mid);
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int countSmallerEqual(int[][] matrix, int val) {
        int n = matrix.length;
        int j = n - 1;
        int cnt = 0;
        for (int[] ints : matrix) {
            while (j >= 0 && ints[j] > val) {
                --j;
            }
            cnt += j + 1;
        }
        return cnt;
    }
}
