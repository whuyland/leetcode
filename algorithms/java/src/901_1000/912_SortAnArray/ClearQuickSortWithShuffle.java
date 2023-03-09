// https://leetcode.com/problems/sort-an-array/

import java.util.Random;

public class ClearQuickSortWithShuffle {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            // if i == j, we still have to go in to loop to place j into right position
            // and because nums[i] and nums[j] reference the same element,
            // and the two condition are counterpart, so one must happen, and will not go to the swap case
            if (nums[i] <= pivot) {
                ++i;
            } else if (nums[j] > pivot) {
                --j;
            } else {
                swap(nums, i, j);
            }
        }
        swap(nums, j, lo);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0; i < n; ++i) {
            swap(nums, i, i + rand.nextInt(n - i));
        }
    }
}
