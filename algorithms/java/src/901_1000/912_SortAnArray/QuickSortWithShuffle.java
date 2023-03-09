// https://leetcode.com/problems/sort-an-array/
import java.util.Random;

public class QuickSortWithShuffle {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // sort nums in place in range [lo, hi]
    private void quickSort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            // no need to sort if less than 1 element is in range
            return;
        }
        int p = partition(nums, lo, hi);
        quickSort(nums, lo, p - 1);
        quickSort(nums, p + 1, hi);
    }

    // after partition, we want the elements satisfy: nums[lo, p - 1] <= pivot < nums[p + 1, hi]

    // the last step is swap nums[lo] with some index x, and it must satisfy nums[x] <= pivot
    // x should be chosen from final values of i and j, the inner while loop has 3 cases:
    // 1. between i and j, there are elements larger than pivot and smaller than pivot,
    //    which can be further divided into two cases, depending on whether the larger is before the smaller
    //    1-a. [pivot] ... l ... s ...     i < j, we swap and keep working
    //                     i     j
    //    1-b. [pivot] ... s ... l ...     ending case, j > i, all elements are settled, loop should be break
    //                     j     i         j is the position satisfying nums[j] < pivot
    // 2. all elements between i and j are larger values
    //    [pivot] ... l l l l ...          ending case, i will stop at the first larger value,
    //              j i                    and j will be at a smaller value or at pivot position
    // 3. all elements between i and j are smaller values
    //    [pivot] ... s s s s ...          ending case, i will stop at the last smaller value or at hi position
    //                      j i            and j will be at the last smaller position
    // So it concludes, j is position to swap with lo at the last step
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
        while (i <= j) { // if i == j, we still have to dive into the inner loop to check if it is case 2 or 3
            // 1. Why nums[i] <= pivot but nums[j] > pivot?
            //    it stops working if both don't take equal, because i and j will not moving towards inner if they both get pivot value
            //    it works if both takes equal, but it can split pivot value in both side, and slower than leave them in one same for some reason
            //    it doesn't matter which side take equal
            //    ==> it always ends with j takes a val that val < pivot or val <= pivot, which should place at low at the end
            // 2. Why i/j compare with hi/lo without equal?
            //    at the very end, i and j should still be valid index
            while (i < hi && nums[i] <= pivot) {
                ++i;
            }
            while (j > lo && nums[j] > pivot) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    // caller should guarantee i and j are valid indices
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
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
