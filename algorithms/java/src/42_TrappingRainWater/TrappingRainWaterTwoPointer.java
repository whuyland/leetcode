// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWaterTwoPointer {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ret = 0;

        int leftMax = height[l];
        int rightMax = height[r];

        // only the pointer at the smaller Max will move towards center
        // if we are the smaller Max at one side, we will add zero to total
        // if we are not not at Max,e.g. leftMax,..., x, ...., rightMax
        // we known that this x will contribute to final: Math.min(leftMax, rightMax) - x
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax) {
                ret += leftMax - height[l];
                ++l;
            } else {
                ret += rightMax - height[r];
                --r;
            }
        }
        return ret;
    }
}
