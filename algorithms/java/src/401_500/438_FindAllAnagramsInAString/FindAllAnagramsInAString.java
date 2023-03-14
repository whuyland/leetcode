import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> startIndices = new LinkedList<>();
        int[] dict = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            ++dict[p.charAt(i) - 'a'];
        }
        int left = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (dict[index] == 0) {
                Arrays.fill(cnt, 0);
                left = i + 1;
                continue;
            }
            while (cnt[index] >= dict[index]) {
                --cnt[s.charAt(left) - 'a'];
                ++left;
            }
            ++cnt[index];
            if (i - left + 1 == p.length()) {
                startIndices.add(left);
            }
        }
        return startIndices;
    }
}
