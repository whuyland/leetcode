import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleIIIndegree {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] row : prerequisites) {
            indegree[row[0]]++;
            graph.putIfAbsent(row[1], new LinkedList<>());
            graph.get(row[1]).add(row[0]);
        }

        Queue<Integer> jobs = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                jobs.offer(i);
            }
        }
        int[] ret = new int[numCourses];
        int top = 0;
        while (!jobs.isEmpty()) {
            int cur = jobs.poll();
            ret[top++] = cur;
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    --indegree[next];
                    if (indegree[next] == 0) {
                        jobs.offer(next);
                    }
                }
            }
        }

        return top == numCourses ? ret : new int[0];
    }
}
