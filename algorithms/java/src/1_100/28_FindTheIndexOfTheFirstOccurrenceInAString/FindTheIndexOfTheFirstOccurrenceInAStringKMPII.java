// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class FindTheIndexOfTheFirstOccurrenceInAStringKMPII {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m) {
            return -1;
        }
        int[][] lps = buildLps(needle);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            j = lps[j][haystack.charAt(i)];
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private int[][] buildLps(String needle) {
        int m = needle.length();
        int[][] lps = new int[m][256];
        // lps[i][j] means: proper prefix and suffix length of: needle[0...i] + (char)j
        lps[0][needle.charAt(0)] = 1;
        int currentLps = 0; // lps of needle[0...i - 1]
        for (int j = 1; j < m; ++j) {
            for (int k = 0; k < 256; ++k) {
                lps[j][k] = lps[currentLps][k];
            }
            lps[j][needle.charAt(j)] = j + 1;
            currentLps = lps[currentLps][needle.charAt(j)];
        }
        return lps;
    }
}
