import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) {
            return;
        }

        if (k < n - k) {
            int[] tmp = Arrays.copyOfRange(nums, n - k, n);
            System.arraycopy(nums, 0, nums, k, n - k);
            System.arraycopy(tmp, 0, nums, 0, k);
        } else {
            int[] tmp = Arrays.copyOf(nums, n - k);
            System.arraycopy(nums, n - k, nums, 0, k);
            System.arraycopy(tmp, 0, nums, k, n - k);
        }
    }
}
