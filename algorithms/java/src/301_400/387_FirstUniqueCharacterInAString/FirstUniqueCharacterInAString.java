import java.util.Arrays;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        Arrays.fill(cnt, n);

        for (int i = 0; i < s.length(); ++i) {
            int ind = s.charAt(i) - 'a';
            if (cnt[ind] == n) { // use n as not-touched value
                cnt[ind] = i;
            } else {
                cnt[ind] = n + 1; // use n + 1 as repeated value
            }
        }
        int ret = n;
        for (int i : cnt) {
            ret = Math.min(ret, i);
        }
        return ret >= n ? -1 : ret;
    }
}
