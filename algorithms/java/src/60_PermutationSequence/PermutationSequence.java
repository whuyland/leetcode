// https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] container = new int[n];
        int product = 1;
        for (int i = 0; i < n; ++i) {
            container[i] = i + 1;
            if (i != 0) {
                product *= i;
            }
        }

        solve(container, 0, k, product);
        StringBuilder sb = new StringBuilder();
        for (int i : container) {
            sb.append(i);
        }
        return sb.toString();
    }

    // in every iteration, we find the correct element for the first index
    // with every element takes the first index, there will be (n - 1)! combinations for the tail,
    // and they will be ordered by the first element,
    // e.g. for n = 4, 1[3! combi], 2[3! combi], 3[3! combi], 4[3! combi],
    // with (n - 1)! we know which element should be first element, we swap this to the first position,
    // and we know the new position we're looking for
    private void solve(int[] container, int currentIndex, int k, int product) {
        if (k == 1) {
            return;
        }

        int target = currentIndex + (k - 1) / product;
        int val = container[target];
        for (int i = target; i > currentIndex; --i) {
            container[i] = container[i - 1];
        }
        container[currentIndex] = val;
        solve(container, currentIndex + 1, k - (k - 1) / product * product, product / (container.length - 1 - currentIndex));
    }
}
