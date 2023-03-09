import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> container = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> anagrams = container.getOrDefault(sorted, new LinkedList<>());
            anagrams.add(s);
            container.put(sorted, anagrams);
        }
        return new ArrayList<>(container.values());
    }
}
