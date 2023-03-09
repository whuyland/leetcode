// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArrayIIRecursive {
    public boolean search(int[] nums, int target) {
        return solve(nums, 0, nums.length - 1, target);
    }

    private boolean solve(int[] nums, int l, int r, int target) {
        if (l > r) {
            return false;
        }

        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return true;
        }

        if (nums[l] == nums[r]) {
            return nums[l] == target || solve(nums, l + 1, r - 1, target);
        }

        if (target > nums[mid]) {
            if (nums[mid] >= nums[l] || target <= nums[r]) {
                return solve(nums, mid + 1, r, target);
            } else {
                return solve(nums, l, mid - 1, target);
            }
        } else {
            if (nums[mid] <= nums[r] || target >= nums[l]) {
                return solve(nums, l, mid - 1, target);
            } else {
                return solve(nums, mid + 1, r, target);
            }
        }
    }
}
