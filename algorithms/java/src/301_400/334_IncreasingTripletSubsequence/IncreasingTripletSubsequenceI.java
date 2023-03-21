// https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequenceI {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int top = 0;
        int min = nums[0];
        // we need one pass to check if there are smaller element before current element,
        // to achieve this, we just record the min value, and compare

        // another pass is backwards to check if there are larger

        // in the first pass, if a value takes the min value, it means it will never
        // be the middle element in the triplet, and in the second pass, we need to find
        // if there are element larger in the right of a element,
        // this min element will not contribute to the final answer, so we can just ignore it
        for (int i = 1; i < n; ++i) {
            if (nums[i] > min) {
                nums[top++] = nums[i];
            } else {
                min = nums[i];
            }
        }
        for (int i = top - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
