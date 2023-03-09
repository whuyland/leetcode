// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int top = 2;
        for (int i = 2; i < nums.length; ++i) {
            // we just need to compare with top[n - 2], because the elements are in order
            if (nums[i] != nums[top - 2]) {
                nums[top++] = nums[i];
            }
        }
        return top;
    }
}
