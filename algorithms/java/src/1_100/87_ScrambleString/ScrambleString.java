import java.util.HashMap;

// https://leetcode.com/problems/scramble-string/
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        return isMatch(s1, 0, s1.length(), s2, 0, s2.length(), new HashMap<>());
    }

    private boolean isMatch(String s1, int start1, int end1, String s2, int start2, int end2, HashMap<String, Boolean> memo) {
        String key = start1 + "," + end1 + "," + start2 + "," + end2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // early stop with counting
        int[] cnt = new int[26];
        for (int i = start1; i < end1; ++i) {
            ++cnt[s1.charAt(i) - 'a'];
        }
        for (int i = start2; i < end2; ++i) {
            --cnt[s2.charAt(i) - 'a'];
        }
        Boolean ret = true;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] != 0) {
                ret = false;
                break;
            }
        }
        if (ret) {
            ret = false;
            if (s1.substring(start1, end1).equals(s2.substring(start2, end2))) {
                ret = true;
            } else {
                for (int len = 1; len < end1 - start1; ++len) {
                    if (isMatch(s1, start1, start1 + len, s2, end2 - len, end2, memo)
                            && isMatch(s1, start1 + len, end1, s2, start2, end2 - len, memo)) {
                        ret = true;
                        break;
                    }
                    if (isMatch(s1, start1, start1 + len, s2, start2, start2 + len, memo)
                            && isMatch(s1, start1 + len, end1, s2, start2 + len, end2, memo)) {
                        ret = true;
                        break;
                    }
                }
            }
        }
        memo.put(key, ret);
        return ret;
    }
}
