import java.util.Arrays;

// https://leetcode.com/problems/wiggle-sort-ii/
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] vals = Arrays.copyOf(nums, n);
        Arrays.sort(vals);
        int j = n;
        for (int i = 1; i < n; i += 2) {
            nums[i] = vals[--j];
        }
        for (int i = 0; i < n; i += 2) {
            nums[i] = vals[--j];
        }
    }
}
