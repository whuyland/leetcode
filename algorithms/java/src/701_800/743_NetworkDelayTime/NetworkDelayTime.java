import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] row : graph) {
            Arrays.fill(row, -1);
        }

        for (int[] row : times) {
            graph[row[0]][row[1]] = row[2];
        }

        Set<Integer> visited = new HashSet<Integer>();
        PriorityQueue<int[]> jobs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        jobs.add(new int[]{0, k});
        int max = 0;
        while (!jobs.isEmpty()) {
            int[] node = jobs.poll();
            if (visited.contains(node[1])) {
                continue;
            }
            max = Math.max(max, node[0]);
            visited.add(node[1]);

            for (int j = 1; j <= n; ++j) {
                if (graph[node[1]][j] != -1 && !visited.contains(j)) {
                    jobs.add(new int[]{node[0] + graph[node[1]][j], j});
                }
            }
        }
        return visited.size() == n ? max : -1;
    }
}
