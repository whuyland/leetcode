// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArrayI {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target) {
            if (nums[mid] >= nums[l]) {
                return search(nums, mid + 1, r, target);
            } else if (target <= nums[r]) {
                return search(nums, mid + 1, r, target);
            } else {
                return search(nums, l, mid - 1, target);
            }
        } else {
            if (nums[mid] <= nums[r]) {
                return search(nums, l, mid - 1, target);
            } else if (target >= nums[l]) {
                return search(nums, l, mid - 1, target);
            } else {
                return search(nums, mid + 1, r, target);
            }
        }
    }
}
