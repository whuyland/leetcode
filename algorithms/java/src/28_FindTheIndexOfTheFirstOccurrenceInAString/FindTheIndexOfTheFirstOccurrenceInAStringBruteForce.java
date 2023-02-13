// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class FindTheIndexOfTheFirstOccurrenceInAStringBruteForce {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m) {
            return -1;
        }
        for (int i = 0; i <= n - m; ++i) {
            int j = i;
            int k = 0;
            while (k < m && haystack.charAt(j) == needle.charAt(k)) {
                ++j;
                ++k;
            }
            if (k == m) {
                return i;
            }
        }
        return -1;
    }
}
