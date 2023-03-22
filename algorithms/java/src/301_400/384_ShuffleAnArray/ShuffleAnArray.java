import java.util.Arrays;
import java.util.Random;

// https://leetcode.com/problems/shuffle-an-array/
public class ShuffleAnArray {
    private final int[] nums;
    private final int[] original;
    private final Random rand;
    private final int n;

    public ShuffleAnArray(int[] nums) {
        this.n = nums.length;
        this.original = Arrays.copyOf(nums, n);
        this.nums = Arrays.copyOf(nums, n);
        this.rand = new Random();
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, n);
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < n; ++i) {
            swap(nums, i, i + rand.nextInt(n - i));
        }
        return nums;
    }

    private void swap(int[] vals, int i, int j) {
        int tmp = vals[i];
        vals[i] = vals[j];
        vals[j] = tmp;
    }
}
