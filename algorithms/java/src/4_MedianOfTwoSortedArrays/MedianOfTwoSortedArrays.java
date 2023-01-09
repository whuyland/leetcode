// https://leetcode.com/problems/median-of-two-sorted-arrays
class MedianOfTwoSortedArrays {
    // more efficient, with elegant binary search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // reference: https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2511/intuitive-python-o-log-m-n-solution-by-kth-smallest-in-the-two-sorted-arrays-252ms/
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 1) {
            return kth(nums1, 0, m, nums2, 0, n, (m + n) / 2);
        }

        return (kth(nums1, 0, m, nums2, 0, n, (m + n) / 2)
                + kth(nums1, 0, m, nums2, 0, n, (m + n) / 2 - 1)) / 2;
    }

    private double kth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        //System.out.println("nums1[" + l1 + ", " + r1 + "], nums2[" + l2 + ", " + r2 + "], k = " + k);
        if (l1 == r1) {
            return nums2[l2 + k];
        }
        if (l2 == r2) {
            return nums1[l1 + k];
        }

        int i1 = (l1 + r1) / 2;
        int i2 = (l2 + r2) / 2;

        int m1 = nums1[i1];
        int m2 = nums2[i2];

        if (i1 + i2 - l1 - l2 < k) {
            // the elements in nums1[l1...i1] + nums[l2...i2] is not enough, we need to expand
            if (m1 < m2) {
                // all elements in nums1[l1...i1] must include in the range,
                // we then search in nums[i1 + 1...r1)
                return kth(nums1, i1 + 1, r1, nums2, l2, r2, k - (i1 - l1 + 1));
            } else {
                return kth(nums1, l1, r1, nums2, i2 + 1, r2, k - (i2 - l2 + 1));
            }
        } else {
            // the elements in nums1[l1...i1] + nums2[l2...i2] is already enough
            // the other half can be discarded
            if (m1 > m2) {
                // the elements in nums1[i1...r1] is irrelvent
                return kth(nums1, l1, i1, nums2, l2, r2, k);
            } else {
                return kth(nums1, l1, r1, nums2, l2, i2, k);
            }
        }
    }

    public double findMedianSortedArraysI(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // We have to visit first 'target' numbers to find out the median
        // for odd case, is just half of the sum, e.g. 3 in [1..5];
        // for even case, we have to visit half + 1 numbers, e.g. 3 and 4 in [1...6]
        int target = (m + n) / 2 + 1;

        // i and j will mark nums1[0...i) and nums2[0..j) are visited
        int i = 0;
        int j = 0;
        int first = 0;
        int second = 0;

        // in every step, one element will be visited
        // and the last visited two elements will be recorede in first and second
        while (i + j < target) {
            first = second;
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    second = nums1[i++];
                } else {
                    second = nums2[j++];
                }
            } else if (i < m) {
                second = nums1[i++];
            } else if (j < n) {
                second = nums2[j++];
            }
        }
        if ((m + n) % 2 == 1) {
            return second;
        }
        return (double) (first + second) / 2;
    }
}
