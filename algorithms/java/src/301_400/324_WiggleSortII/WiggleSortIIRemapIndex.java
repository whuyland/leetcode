// https://leetcode.com/problems/wiggle-sort-ii/
public class WiggleSortIIRemapIndex {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        int mid = nums[kth(nums, half, 0, n - 1)];

        // 3-way-partition
        // l is the index of first mid
        // r is the index of first val that smaller than mid
        int l = 0;
        int r = n;
        int i = 0;
        while (i < r) {
            int val = nums[getIndex(i, half)];
            if (val > mid) {
                swap(nums, getIndex(i, half), getIndex(l, half));
                ++i;
                ++l;
            } else if (val < mid) {
                --r;
                swap(nums, getIndex(i, half), getIndex(r, half));
            } else {
                ++i;
            }
        }
    }

    // decreasing, total 7
    // 0 1 2 3 4 5 6
    // 3 0 4 1 5 2 6
    // decreasing, total 8
    // 0 1 2 3 4 5 6 7
    // 4 0 5 1 6 2 7 3
    // formal: (2 * i + 1) % (n | 1);
    private int getIndex(int i, int half) {
        if (i < half) {
            return 2 * i + 1;
        }
        return (i - half) * 2;
    }

    private int kth(int[] nums, int k, int lo, int hi) {
        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return pivot;
        }
        if (pivot < k) {
            return kth(nums, k, pivot + 1, hi);
        }
        return kth(nums, k, lo, pivot - 1);
    }

    private int partition(int[] nums, int lo, int hi) {
        int l = lo + 1;
        int r = hi;
        while (l <= r) {
            if (nums[l] <= nums[lo]) {
                ++l;
            } else if (nums[r] > nums[lo]) {
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
}
