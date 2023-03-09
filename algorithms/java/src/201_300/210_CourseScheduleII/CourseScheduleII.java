import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new LinkedList<>());
        }
        for (int[] row : prerequisites) {
            graph.get(row[0]).add(row[1]);
        }

        Set<Integer> seen = new HashSet<>();
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!seen.contains(i)) {
                if (!dfs(graph, i, new HashSet<>(), seen, ans)) {
                    break;
                }
            }
        }

        if (seen.size() != numCourses) {
            ans.clear();
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int i, Set<Integer> visited, Set<Integer> seen, List<Integer> ans) {
        visited.add(i);
        for (int pre : graph.get(i)) {
            if (visited.contains(pre)) {
                return false;
            }
            if (seen.contains(pre)) {
                continue;
            }
            if (!dfs(graph, pre, visited, seen, ans)) {
                return false;
            }
        }
        visited.remove(i);
        ans.add(i);
        seen.add(i);
        return true;
    }
}
