//https://leetcode.com/problems/majority-element/
public class MajorityElementI {
    public int majorityElement(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int left, int right) {
        int target = nums[left];
        int i = left + 1;
        int lb = left;
        int ub = right;
        while (i <= ub) {
            if (nums[i] == target) {
                ++i;
            } else if (nums[i] < target) {
                swap(nums, lb, i);
                ++lb;
                ++i;
            } else {
                swap(nums, i, ub);
                --ub;
            }
        }

        if (ub - lb + 1 > nums.length / 2) {
            return target;
        }
        int leftLen = lb - left;
        int rightLen = right - ub;
        return leftLen > rightLen ? solve(nums, left, lb - 1) : solve(nums, ub + 1, right);
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
