import java.util.*;

// https://leetcode.com/problems/word-ladder-ii/
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!isPossible(endWord, wordList)) {
            return new ArrayList<>();
        }

        // nextDic and prevDic are the same
        Map<String, Set<String>> nextDic = buildNextDic(beginWord, endWord, wordList);

        LinkedList<String> forwardJobs = new LinkedList<>();
        forwardJobs.add(beginWord);
        LinkedList<String> backwardJobs = new LinkedList<>();
        backwardJobs.add(endWord);

        Map<String, Set<String>> prevList = new HashMap<>();
        prevList.put(beginWord, new HashSet<>());

        Map<String, Set<String>> nextList = new HashMap<>();
        nextList.put(endWord, new HashSet<>());
        Set<String> meetPoint = new HashSet<>();
        boolean forward = true;

        while (meetPoint.isEmpty() && !forwardJobs.isEmpty() && !backwardJobs.isEmpty()) {
            if (forward) {
                process(nextDic, forwardJobs, prevList);
            } else {
                process(nextDic, backwardJobs, nextList);
            }
            forward = !forward;
            for (String s : prevList.keySet()) {
                if (nextList.containsKey(s)) {
                    meetPoint.add(s);
                }
            }
        }
        if (meetPoint.isEmpty()) {
            return new ArrayList<>();
        }
        return buildResult(meetPoint, prevList, nextList);
    }

    private void process(Map<String, Set<String>> nextDic, LinkedList<String> jobs, Map<String, Set<String>> chain) {
        int n = jobs.size();
        Set<String> seenThisStep = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            String word = jobs.removeFirst();
            for (String next : nextDic.get(word)) {
                if (!chain.containsKey(next) || seenThisStep.contains(next)) {
                    jobs.add(next);
                    seenThisStep.add(next);
                    chain.putIfAbsent(next, new HashSet<>());
                    chain.get(next).add(word);
                }
            }
        }
    }

    private List<List<String>> buildResult(Set<String> meetPoint, Map<String, Set<String>> prevList, Map<String, Set<String>> nextList) {
        List<List<String>> ret = new ArrayList<>();
        LinkedList<LinkedList<String>> jobs = new LinkedList<>();
        for (String word : meetPoint) {
            LinkedList<String> ans = new LinkedList<>();
            ans.add(word);
            jobs.add(ans);
        }

        // add first half
        while (prevList.get(jobs.getFirst().getFirst()).size() != 0) {
            int n = jobs.size();
            for (int i = 0; i < n; ++i) {
                LinkedList<String> job = jobs.removeFirst();
                for (String prev : prevList.get(job.getFirst())) {
                    LinkedList<String> copy = new LinkedList<>(job);
                    copy.addFirst(prev);
                    jobs.add(copy);
                }
            }
        }
        // add second half
        while (nextList.get(jobs.getFirst().getLast()).size() != 0) {
            int n = jobs.size();
            for (int i = 0; i < n; ++i) {
                LinkedList<String> job = jobs.removeFirst();
                for (String next : nextList.get(job.getLast())) {
                    LinkedList<String> copy = new LinkedList<>(job);
                    copy.add(next);
                    jobs.add(copy);
                }
            }
        }

        ret.addAll(jobs);
        return ret;
    }

    private Map<String, Set<String>> buildNextDic(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord); // consider beginWord too

        Map<String, Set<String>> nextDic = new HashMap<>(); // use set to avoid duplicate
        for (String word : wordList) {
            nextDic.put(word, new HashSet<>());
        }

        for (int i = 0; i < beginWord.length(); ++i) {
            // collect same representation of different words togegher
            // we consider remove one char in every position
            Map<String, List<String>> dic = new HashMap<>();
            for (String word : wordList) {
                String rep = getRep(word, i);
                dic.putIfAbsent(rep, new ArrayList<>());
                dic.get(rep).add(word);
            }
            dic.forEach((key, words) -> {
                int num = words.size();
                for (int j = 0; j < num; ++j) {
                    for (int k = j + 1; k < num; ++k) {
                        nextDic.get(words.get(j)).add(words.get(k));
                        nextDic.get(words.get(k)).add(words.get(j));
                    }
                }
            });
        }
        return nextDic;
    }

    private String getRep(String word, int i) {
        return word.substring(0, i) + word.substring(i + 1);
    }

    private boolean isPossible(String endWord, List<String> wordList) {
        for (String s : wordList) {
            if (endWord.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
