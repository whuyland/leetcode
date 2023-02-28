import java.util.*;

// https://leetcode.com/problems/course-schedule/
public class CourseScheduleIndegree {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] row : prerequisites) {
            ++indegree[row[0]];
            graph.putIfAbsent(row[1], new LinkedList<>());
            graph.get(row[1]).add(row[0]);
        }

        int visited = 0;
        LinkedList<Integer> jobs = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                jobs.add(i);
            }
        }
        while (!jobs.isEmpty()) {
            ++visited;
            int pre = jobs.removeFirst();
            if (!graph.containsKey(pre)) {
                continue;
            }

            for (int next : graph.get(pre)) {
                --indegree[next];
                if (indegree[next] == 0) {
                    jobs.add(next);
                }
            }
        }
        return visited == numCourses;
    }
}
