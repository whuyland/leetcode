// https://leetcode.com/problems/product-of-array-except-self/
public class ProductArrayExceptSelfI {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] forward = new int[n + 1];
        forward[0] = 1;
        for (int i = 0; i < n; ++i) {
            forward[i + 1] = forward[i] * nums[i];
        }

        int[] backward = new int[n + 1];
        backward[n] = 1;
        for (int i = n - 1; i >= 0; --i) {
            backward[i] = backward[i + 1] * nums[i];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; ++i) {
            ret[i] = forward[i] * backward[i + 1];
        }
        return ret;
    }
}
