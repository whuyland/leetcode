import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/the-skyline-problem/
public class TheSkylineProblemI {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[][] keyPoints = new int[2 * n][2];
        for (int i = 0; i < n; ++i) {
            int[] row = buildings[i];
            keyPoints[2 * i][0] = row[0];
            keyPoints[2 * i][1] = row[2]; // use positive value to mark up edge
            keyPoints[2 * i + 1][0] = row[1];
            keyPoints[2 * i + 1][1] = -row[2]; // use negative to mark down edge
        }
        Arrays.sort(keyPoints, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // if at same x-value, we favor larger height
            }
            return a[0] - b[0]; // favor points that appears early
        });

        int maxHeight = 0;
        List<List<Integer>> ret = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // use pq to remember current seen height
        for (int[] row : keyPoints) {
            if (row[1] > 0) {
                pq.add(row[1]);
            } else {
                pq.remove(-row[1]);
            }
            int currentMax = pq.isEmpty() ? 0 : pq.peek();
            if (currentMax != maxHeight) {
                maxHeight = currentMax;
                addKeyPoint(ret, row[0], maxHeight);
            }
        }
        return ret;
    }

    private void addKeyPoint(List<List<Integer>> ret, int key, int val) {
        ret.add(new LinkedList<>(Arrays.asList(key, val)));
    }
}
