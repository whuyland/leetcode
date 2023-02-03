public class ThreePartitionQuickSort {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        putMidLow(nums, lo, hi);

        // [large, hi] are all larger value
        // [mid, i) are all same values
        // [lo, mid) are all smaller values
        int mid = lo;
        int large = hi + 1;
        int i = mid + 1;

        int pivot = nums[lo];
        while (i < large) {
            if (nums[i] > pivot) {
                --large;
                swap(nums, i, large);
            } else if (nums[i] == pivot) {
                ++i;
            } else /* if (nums[i] < pivot) */ {
                swap(nums, mid, i);
                ++mid;
                ++i;
            }
        }
        sort(nums, lo, mid - 1);
        sort(nums, large, hi);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // substitute from lo, mid, hi
    //               == mid, low, hi
    private void putMidLow(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (nums[mid] > nums[lo]) {
            swap(nums, lo, mid);
        }
        if (nums[lo] > nums[hi]) {
            swap(nums, lo, hi);
        }
        if (nums[mid] > nums[lo]) {
            swap(nums, lo, mid);
        }
    }
}
