import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/max-points-on-a-line/
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int[][] memo = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (memo[i][j] != 0) {
                    continue;
                }
                List<Integer> line = new LinkedList<>();
                line.add(i);
                line.add(j);
                for (int k = j + 1; k < n; ++k) {
                    if (onSameLine(points[i], points[j], points[k])) {
                        line.add(k);
                    }
                }
                for (int p : line) {
                    for (int q : line) {
                        memo[p][q] = 1;
                    }
                }
                max = Math.max(max, line.size());
            }
        }
        return max;
    }

    private boolean onSameLine(int[] x, int[] y, int[] z) {
        // cross product is zero
        return (y[1] - x[1]) * (z[0] - x[0]) == (y[0] - x[0]) * (z[1] - x[1]);
    }
}
