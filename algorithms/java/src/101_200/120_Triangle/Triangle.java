import java.util.List;

// https://leetcode.com/problems/triangle/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] tmp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            tmp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                tmp[j] = triangle.get(i).get(j) + Math.min(tmp[j], tmp[j + 1]);
            }
        }
        return tmp[0];
    }
}
