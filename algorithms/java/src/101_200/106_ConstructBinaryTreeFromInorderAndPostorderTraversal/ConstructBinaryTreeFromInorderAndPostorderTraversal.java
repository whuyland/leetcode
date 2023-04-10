// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iL, int iR, int[] postorder, int pL, int pR) {
        if (iR < iL) {
            return null;
        }
        // the last value in postOrder is the root value
        int leftLen = 0;
        while (inorder[iL + leftLen] != postorder[pR]) {
            ++leftLen;
        }
        return new TreeNode(postorder[pR],
                build(inorder, iL, iL + leftLen - 1, postorder, pL, pL + leftLen - 1),
                build(inorder, iL + leftLen + 1, iR, postorder, pL + leftLen, pR - 1));
    }
}
