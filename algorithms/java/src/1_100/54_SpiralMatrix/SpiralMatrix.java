import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        solve(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, 0, ans);
        return ans;
    }

    // direction:
    // 0: top-left to top-right,
    // 1: right-top to rihgt-bottom,
    // 2: bottom-right to bottom-left
    // 3: left-bottom to left-top
    private void solve(int[][] matrix, int startI, int endI, int startJ, int endJ, int direction, List<Integer> ans) {
        if (startI > endI || startJ > endJ) {
            return;
        }
        if (direction == 0) {
            for (int j = startJ; j <= endJ; ++j) {
                ans.add(matrix[startI][j]);
            }
            solve(matrix, startI + 1, endI, startJ, endJ, 1, ans);
        } else if (direction == 1) {
            for (int i = startI; i <= endI; ++i) {
                ans.add(matrix[i][endJ]);
            }
            solve(matrix, startI, endI, startJ, endJ - 1, 2, ans);
        } else if (direction == 2) {
            for (int j = endJ; j >= startJ; --j) {
                ans.add(matrix[endI][j]);
            }
            solve(matrix, startI, endI - 1, startJ, endJ, 3, ans);
        } else if (direction == 3) {
            for (int i = endI; i >= startI; --i) {
                ans.add(matrix[i][startJ]);
            }
            solve(matrix, startI, endI, startJ + 1, endJ, 0, ans);
        }
    }
}
