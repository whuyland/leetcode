import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int l = 0; l <= i - 1; ++l) {
                memo[i] += memo[l] * memo[i - 1 - l];
            }
        }
        return memo[n];
    }
}
