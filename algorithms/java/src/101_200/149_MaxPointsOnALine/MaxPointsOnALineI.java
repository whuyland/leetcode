import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/max-points-on-a-line/
public class MaxPointsOnALineI {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int vertical = 1;
            int maxVal = 1;
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];
                if (dx == 0) {
                    ++vertical;
                } else {
                    int p = gcd(dy, dx);
                    dy /= p;
                    dx /= p;
                    String key = dy + "," + dx;
                    int val = cnt.getOrDefault(key, 1) + 1;
                    maxVal = Math.max(val, maxVal);
                    cnt.put(key, val);
                }
            }
            cnt.clear();
            ret = Math.max(ret, Math.max(vertical, maxVal));
        }
        return ret;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
