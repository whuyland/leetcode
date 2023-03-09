// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int numWords = words.length;
        int wordLen = words[0].length();
        int totalLen = numWords * wordLen;

        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        LinkedList<String> seen = new LinkedList<>();
        List<Integer> ret = new LinkedList<>();

        for (int startIndex = 0; startIndex < wordLen; ++startIndex) {
            for (int i = startIndex; i <= s.length() - wordLen; i += wordLen) {
                String cur = s.substring(i, i + wordLen);
                if (!dict.containsKey(cur)) {
                    while (!seen.isEmpty()) {
                        String first = seen.removeFirst();
                        dict.put(first, dict.get(first) + 1);
                    }
                } else {
                    while (dict.get(cur) == 0) {
                        String first = seen.removeFirst();
                        dict.put(first, dict.get(first) + 1);
                    }
                    dict.put(cur, dict.get(cur) - 1);
                    seen.add(cur);
                    if (seen.size() == numWords) {
                        ret.add(i + wordLen - totalLen);
                    }
                }
            }
            while (!seen.isEmpty()) {
                String first = seen.removeFirst();
                dict.put(first, dict.get(first) + 1);
            }
        }
        return ret;
    }
}
