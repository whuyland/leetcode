// https://leetcode.com/problems/product-of-array-except-self/
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1; i < n; ++i) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = n - 1; i >= 0; --i) {
            ret[i] *= product;
            product *= nums[i];
        }
        return ret;
    }
}
