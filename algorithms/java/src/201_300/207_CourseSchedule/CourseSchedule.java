import java.util.*;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] row : prerequisites) {
            graph.putIfAbsent(row[0], new LinkedList<>());
            graph.get(row[0]).add(row[1]);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < numCourses; ++i) {
            if (seen.contains(i)) {
                continue;
            }
            if (!dfs(graph, i, new HashSet<>(), seen)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int i, Set<Integer> onStack, Set<Integer> seen) {
        if (onStack.contains(i)) {
            return false;
        }
        if (seen.contains(i)) {
            return true;
        }

        onStack.add(i);
        seen.add(i);
        if (graph.containsKey(i)) {
            for (int pre : graph.get(i)) {
                if (!dfs(graph, pre, onStack, seen)) {
                    return false;
                }
            }
        }

        onStack.remove(i);
        return true;
    }
}
