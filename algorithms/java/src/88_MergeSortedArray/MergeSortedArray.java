// https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[pos--] = nums2[j--];
            } else {
                nums1[pos--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[pos--] = nums2[j--];
        }
    }
}
