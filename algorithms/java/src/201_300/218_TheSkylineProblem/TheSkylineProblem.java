import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/the-skyline-problem/
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Arrays.sort(buildings, (a, b) -> {
            if (a[0] == b[0]) {
                return b[2] - a[2];
            }
            return a[0] - b[0];
        });

        List<List<Integer>> ret = new LinkedList<>();
        PriorityQueue<int[]> seen = new PriorityQueue<>((a, b) -> {
            if (b[2] == a[2]) {
                return b[1] - a[1];
            }
            return b[2] - a[2];
        });
        int n = buildings.length;
        for (int i = 0; i <= n; ++i) {
            // we need to enter loop one more time to empty stack
            int[] row = i < n ? buildings[i] : null;

            // remove invalid buildings, and add the downwards edge
            while (!seen.isEmpty() && (i == n || seen.peek()[1] < row[0])) {
                int[] highest = seen.poll();
                while (!seen.isEmpty() && seen.peek()[1] <= highest[1]) {
                    int[] polled = seen.poll();
                }
                int low = seen.isEmpty() ? 0 : seen.peek()[2];
                addKeyPoint(ret, highest[1], low);
            }

            // add upwards edge
            if (i < n) {
                if (seen.isEmpty() || row[2] > seen.peek()[2]) {
                    addKeyPoint(ret, row[0], row[2]);
                }
                seen.add(row);
            }
        }

        return ret;
    }

    private void addKeyPoint(List<List<Integer>> ret, int key, int val) {
        ret.add(new LinkedList<>(Arrays.asList(key, val)));
    }
}
