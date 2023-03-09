//https://leetcode.com/problems/majority-element/
// Boyer-Moore Voting Algorithm
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (cnt == 0) {
                ++cnt;
                candidate = nums[i];
                continue;
            }
            cnt += candidate == nums[i] ? 1 : -1;
        }
        return candidate;
    }
}
