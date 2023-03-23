import java.util.Arrays;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtLeastKRepeatingCharactersSlidingWindow {
    public int longestSubstring(String s, int k) {
        int numUnique = maxUnique(s);
        int[] freqs = new int[26];
        int ret = 0;
        // use unique number to slide window
        for (int target = 1; target <= numUnique; ++target) {
            int unique = 0;
            int numValid = 0; // num of char that appears k or more times
            Arrays.fill(freqs, 0);
            int l = 0;
            int r = 0;
            while (r < s.length()) {
                // r will increase to string end, if unique <= target
                // after adding the last char:
                // 1. it will reach target, the result is add at last
                // 2. it will be lower than target, no more chars to use, stop sliding
                // 3. it will be just over target, and in the next step we have to move l right,
                //    but we have just consider result for [l...r], to make r+1 valid right edge,
                //    we have to at least move l one step, and the result will not be better than
                //    previous result
                if (unique <= target) {
                    int idx = s.charAt(r) - 'a';
                    if (freqs[idx] == 0) {
                        ++unique;
                    }
                    ++freqs[idx];
                    if (freqs[idx] == k) {
                        ++numValid;
                    }
                    ++r;
                } else {
                    int idx = s.charAt(l) - 'a';
                    if (freqs[idx] == k) {
                        --numValid;
                    }
                    --freqs[idx];
                    if (freqs[idx] == 0) {
                        --unique;
                    }
                    ++l;
                }
                if (unique == numValid) {
                    ret = Math.max(ret, r - l);
                }
            }
        }
        return ret;
    }

    private int maxUnique(String s) {
        boolean[] seen = new boolean[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';
            if (!seen[idx]) {
                ++cnt;
                seen[idx] = true;
            }
        }
        return cnt;
    }
}
