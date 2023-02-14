// https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    // lower bound
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
