// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {
        if (pL >= pR) {
            return null;
        }

        int rootVal = preorder[pL];
        int leftLen = 0;
        while (inorder[iL + leftLen] != rootVal) {
            ++leftLen;
        }
        return new TreeNode(rootVal,
                buildTree(preorder, pL + 1, pL + 1 + leftLen, inorder, iL, iL + leftLen),
                buildTree(preorder, pL + 1 + leftLen, pR, inorder, iL + leftLen + 1, iR));
    }
}
