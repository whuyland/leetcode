// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtLeastKRepeatingCharacters {
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
        for (int i = start; i < end; ++i) {
            if (freqs[s.charAt(i) - 'a'] < k) {
                // split into two half, if we find invalid char
                int mid = i++;
                while (i < end && freqs[s.charAt(i) - 'a'] < k) {
                    ++i;
                }
                return Math.max(solve(s, start, mid, k), solve(s, i, end, k));
            }
        }
        return end - start;
    }
}
