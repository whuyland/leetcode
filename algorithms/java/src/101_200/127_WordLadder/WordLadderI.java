import java.util.*;

// https://leetcode.com/problems/word-ladder/
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = wordList.size();
        Integer endIndex = null;
        for (int i = 0; i < n; ++i) {
            graph.put(i, new LinkedList<>());
            if (endIndex == null && endWord.equals(wordList.get(i))) {
                endIndex = i;
            }
        }
        if (endIndex == null) {
            return 0;
        }

        graph.put(n, new LinkedList<>());

        for (int i = 0; i < n; ++i) {
            String s = wordList.get(i);
            if (isAdjacent(beginWord, s)) {
                graph.get(n).add(i);
            }

            for (int j = i + 1; j < n; ++j) {
                String t = wordList.get(j);
                if (isAdjacent(s, t)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        return dijkstra(n, endIndex, graph);
    }

    private int dijkstra(int start, int end, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> jobs = new PriorityQueue<>((a, b) -> a[0] - b[0]); // 0: length, 1: val
        jobs.add(new int[]{1, start});
        while (!jobs.isEmpty()) {
            int[] top = jobs.poll();
            if (visited.contains(top[1])) {
                continue;
            }
            if (top[1] == end) {
                return top[0];
            }
            visited.add(top[1]);
            for (int next : graph.get(top[1])) {
                jobs.add(new int[]{top[0] + 1, next});
            }
        }
        return 0;
    }

    private boolean isAdjacent(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                ++cnt;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return cnt == 1;
    }
}
