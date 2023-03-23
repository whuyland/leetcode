// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtLeastKRepeatingCharactersI {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }
        int[] freqs = new int[26];
        for (int i = start; i < end; ++i) {
            freqs[s.charAt(i) - 'a']++;
        }
        int sub = 0;
        int left = start;
        for (int i = start; i < end; ++i) {
            if (freqs[s.charAt(i) - 'a'] < k) {
                sub = Math.max(sub, solve(s, left, i, k));
                left = i + 1;
            }
        }
        if (left != start) {
            sub = Math.max(sub, solve(s, left, end, k));
            return sub;
        }
        return end - start;
    }
}
