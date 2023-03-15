import java.util.*;

// https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        int len = beginWord.length();
        int n = wordList.size();
        for (String s : wordList) {
            if (s.length() != len) {
                continue;
            }
            for (int j = 0; j < len; ++j) {
                String sub = getSub(s, j);
                graph.putIfAbsent(sub, new LinkedList<>());
                graph.get(sub).add(s);
            }
        }
        return dijkstra(beginWord, endWord, graph);
    }

    private int dijkstra(String start, String end, Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        LinkedList<String> jobs = new LinkedList<>();
        jobs.add(start);
        int cnt = 1;
        while (!jobs.isEmpty()) {
            int n = jobs.size();
            ++cnt;
            for (int i = 0; i < n; ++i) {
                String top = jobs.removeFirst();
                if (visited.contains(top)) {
                    continue;
                }
                visited.add(top);

                for (int j = 0; j < start.length(); ++j) {
                    String sub = getSub(top, j);
                    for (String next : graph.getOrDefault(sub, new LinkedList<>())) {
                        if (next.equals(end)) {
                            return cnt;
                        }
                        jobs.add(next);
                    }
                }
            }
        }
        return 0;
    }

    private String getSub(String s, int i) {
        return s.substring(0, i) + "." + s.substring(i + 1);
    }
}
