// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Integer[] ans = new Integer[1];
        traverse(root, k, ans);
        return ans[0];
    }

    private int traverse(TreeNode root, int k, Integer[] ans) {
        if (root == null) {
            return 0;
        }
        int leftCnt = traverse(root.left, k, ans);
        if (leftCnt + 1 == k) {
            ans[0] = root.val;
        }
        int rightCnt = traverse(root.right, k - leftCnt - 1, ans);
        return leftCnt + rightCnt + 1;
    }
}
