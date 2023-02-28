import java.util.Random;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return findKth(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKth(int[] nums, int lo, int hi, int k) {
        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return nums[pivot];
        }
        return pivot < k ? findKth(nums, pivot + 1, hi, k) : findKth(nums, lo, pivot - 1, k);
    }

    private int partition(int[] nums, int lo, int hi) {
        int target = nums[lo];
        int l = lo + 1;
        int r = hi;
        while (l <= r) {
            if (nums[l] <= target) {
                ++l;
            } else if (nums[r] > target) {
                --r;
            } else {
                swap(nums, l, r);
                ++l;
                --r;
            }
        }
        swap(nums, lo, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        Random r = new Random();
        for (int i = 0; i < n; ++i) {
            swap(nums, i, r.nextInt(n - i));
        }
    }
}
