// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int pivot = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                pivot = i;
                break;
            }
        }
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            int val = nums[(mid + pivot) % nums.length];
            if (val == target) {
                return true;
            }
            if (val > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
