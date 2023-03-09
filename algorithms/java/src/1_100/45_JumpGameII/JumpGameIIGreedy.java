// https://leetcode.com/problems/jump-game-ii/
class JumpGameIIGreedy {
    public int jump(int[] nums) {
        int step = 0;
        int cur = 0;
        int rangeEnd = 0;
        while (rangeEnd < nums.length - 1) {
            int currentEnd = rangeEnd;
            while (cur <= currentEnd) {
                rangeEnd = Math.max(rangeEnd, nums[cur] + cur);
                if (rangeEnd >= nums.length - 1) {
                    break;
                }
                ++cur;
            }
            ++step;
        }
        return step;
    }
}
