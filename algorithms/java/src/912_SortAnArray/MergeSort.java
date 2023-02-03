// https://leetcode.com/problems/sort-an-array/
public class MergeSort {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int lo, int hi, int[] temp) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(nums, lo, mid, temp);
        mergeSort(nums, mid + 1, hi, temp);
        merge(nums, lo, mid, hi, temp);
    }

    private void merge(int[] nums, int lo, int mid, int hi, int[] temp) {
        for (int i = lo; i <= hi; ++i) {
            temp[i] = nums[i];
        }

        int i = lo;
        int j = mid + 1;
        int pos = lo;
        while (i <= mid && j <= hi) {
            if (temp[i] < temp[j]) {
                nums[pos++] = temp[i++];
            } else {
                nums[pos++] = temp[j++];
            }
        }
        while (i <= mid) {
            nums[pos++] = temp[i++];
        }
        while (j <= hi) {
            nums[pos++] = temp[j++];
        }
    }
}
