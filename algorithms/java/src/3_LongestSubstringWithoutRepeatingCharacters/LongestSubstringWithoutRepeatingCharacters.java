// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> store = new HashMap<>();

        int maxLength = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            if (store.containsKey(c)) {
                if (store.size() > maxLength) {
                    maxLength = store.size();
                }

                // element left of 'c' is not useful
                int oldIndex = store.get(c);
                for (int j = begin; j <= oldIndex; ++j) {
                    store.remove(s.charAt(j));
                }
                begin = oldIndex + 1;
            }
            store.put(c, i);
        }
        if (store.size() > maxLength) {
            maxLength = store.size();
        }
        return maxLength;
    }

    // remove the deletion part
    public int lengthOfLongestSubstringII(String s) {
        Map<Character, Integer> store = new HashMap<>();

        int maxLength = 0;
        int l = 0;

        for (int r = 0; r < s.length(); ++r) {
            Character c = s.charAt(r);
            if (store.containsKey(c)) {
                // if there is a duplicate character, 'l' needs to move towards right,
                // without deletion, there can be leftover character before 'l' in the store,
                // so a max operation is needed to remove this case, e.g. "abba"
                l = Math.max(l, store.get(c) + 1);
            }
            store.put(c, r);

            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
