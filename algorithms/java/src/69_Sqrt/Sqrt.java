// https://leetcode.com/problems/sqrtx/
public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int r = x / 2; // (x / 2) * (x / 2) >= x for x >= 2
        while (l <= r) {
            int mid = (l + r) / 2;
            int q = x / mid;
            if (q == mid) {
                return mid;
            } else if (q > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
