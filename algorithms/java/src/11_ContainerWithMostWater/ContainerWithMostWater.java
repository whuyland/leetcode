// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int ret = 0;
        // 1. Informal prof:
        //    Once we visited a_i and a_j and a_i < a_j,
        //    if we move a_j left, with a_i as the left side, the area can not increase.
        //    but if we move a_i right, and keep a_j as right, the area may increase.
        //    This prof is just make one step from current solution.
        //    It just proves it can arrive a local optimal, may not be the global best.
        // 2. Prof with contradiction
        // https://leetcode.com/problems/container-with-most-water/solutions/6089/Anyone-who-has-a-O(N)-algorithm/comments/7268/
        //    Suppose best values are a_ol and a_or, with l < r.
        //    If the solution is wrong, we will not visit a_ol and a_or at the same time.
        //    Because the solution only stops when l meet r, and l only moves towards right, r towards left.
        //    So at some time, we will definitely have l at a_ol before r touches a_or or r at a_or before l touches a_ol.
        //    Let's assume, currently l stops at a_ol, and r will miss a_or only if:
        //    1. the algorithm stops. But in that case, r will visit a_or. -- contradiction
        //    2. We meet a_rr, which right a_or and greater than a_ol, which makes a_ol moves.
        //       But in that case, with relative position: a_ol ... a_or ... a_rr and a_rr > a_ol,
        //       The area of a_ol and a_rr is greater than a_ol and a_or. -- contradiction with a_ol and a_or are best.

        while (l < r) {
            ret = Math.max(ret, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ret;
    }
}
