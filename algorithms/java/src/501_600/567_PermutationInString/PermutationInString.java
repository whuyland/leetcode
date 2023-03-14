import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] dict = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            ++dict[s1.charAt(i) - 'a'];
        }

        int[] cnt = new int[26];
        int left = 0;
        for (int i = 0; i < s2.length(); ++i) {
            int index = s2.charAt(i) - 'a';
            if (dict[index] == 0) {
                Arrays.fill(cnt, 0);
                left = i + 1;
                continue;
            }
            ++cnt[index];
            while (cnt[index] > dict[index]) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (i - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
