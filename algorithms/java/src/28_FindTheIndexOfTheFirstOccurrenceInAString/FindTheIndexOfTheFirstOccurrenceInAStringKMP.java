// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class FindTheIndexOfTheFirstOccurrenceInAStringKMP {
    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/3121002/find-the-index-of-the-first-occurrence-in-a-string/
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m) {
            return -1;
        }

        int[] lps = new int[m]; // longest proper prefix and suffix
        // lps[0] = 0, empty string have no proper prefix
        int currentLps = 0;
        int j = 1;
        while (j < m) {
            if (needle.charAt(currentLps) == needle.charAt(j)) {
                // in this case, currentLps can absolutely enlarge
                lps[j] = ++currentLps;
                ++j;
            } else if (currentLps == 0) {
                // needle[0] and needle[j] are different, no lps
                ++j;
            } else {
                // needle[0...currentLps-1] are matched with needle[?...j - 1],
                // so we get newLps = lps[currentLps - 1],
                // needle[0...newLps-1] can match with lps[??...j-1]
                currentLps = lps[currentLps - 1];
            }
        }

        int i = 0;
        j = 0;
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else if (j == 0) {
                ++i;
            } else {
                // needle[j] != haystack[i], but we know needle[0...j-1] are matched,
                // we get the longest prefix-suffix newJ = lps[j - 1],
                // which matches needle[0...newJ - 1]
                // lps is the lps length, which is also the next index to compare
                j = lps[j - 1];
            }
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }
}
