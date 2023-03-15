// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }
        int mid = (l + r) / 2;
        return new TreeNode(nums[mid], build(nums, l, mid), build(nums, mid + 1, r));
    }
}
