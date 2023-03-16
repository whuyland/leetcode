// https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid == l || nums[mid - 1] > nums[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return l;
    }
}
