// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        int maxIndex = 0;
        int total = 0;
        // It is only possible to collect water if there are high bars in the two sides,
        // and there are low bars in between.

        // We want to iterate through the bars, and if we are at ith, and find it is a high bar,
        // what matters is only the highest bar before ith.

        // Suppose we are at the hightest bar, and move on,
        // if we meet ith bar, and it is not taller than (i-1)th bar, it will not contribute to final result.
        for (int i = 1; i < height.length; ++i) {
            if (height[i] <= height[i - 1]) {
                continue;
            }
            total += trapAndRemember(height, maxIndex, i);
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        return total;
    }

    private int trapAndRemember(int[] height, int startIndex, int endIndex) {
        int total = 0;
        int barValue = Math.min(height[startIndex], height[endIndex]);
        // we process both case toghter
        for (int i = endIndex - 1; i > startIndex; --i) {
            if (height[i] >= barValue) {
                break;
            }
            total += barValue - height[i];
            height[i] = barValue;
        }

        // if (height[endIndex] >= height[startIndex]) {
        //     for (int i = startIndex; i < endIndex; ++i) {
        //         total += height[startIndex] - height[i];
        //         height[i] = height[startIndex];
        //     }
        // } else {
        //     for (int i = endIndex - 1; i > startIndex; --i) {
        //         if (height[i] >= height[endIndex]) {
        //             break;
        //         }
        //         total += height[endIndex] - height[i];
        //         height[i] = height[endIndex];
        //     }
        // }
        return total;
    }
}
