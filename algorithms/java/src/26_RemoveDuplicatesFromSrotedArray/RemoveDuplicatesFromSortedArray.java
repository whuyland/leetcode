// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int top = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[top]) {
                nums[++top] = nums[i];
            }
        }
        return top + 1;
    }
}
