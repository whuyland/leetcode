// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] nums) {
        int pos = 0; // where we are
        int far = 0; // the farthest position we can arrive at this step
        while (pos < nums.length && far < nums.length - 1) {
            int end = far;
            while (pos <= end) {
                far = Math.max(far, pos + nums[pos++]);
            }
            if (far == end) {
                return false;
            }
        }
        return true;
    }
}
