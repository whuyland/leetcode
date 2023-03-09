// https://leetcode.com/problems/n-queens-ii/
public class NQueensIIBitOperation {
    public int totalNQueens(int n) {
        int count = 0;
        count = solve(n, 0, 0, 0, 0, count);
        return count;
    }

    // diag1 is top-right to bottom-let
    private int solve(int n, int row, int cols, int diag1, int diag2, int count) {
        if (row == n) {
            count++;
        } else {
            int availablePositions = ((1 << n) - 1) & ~(cols | diag1 | diag2);
            while (availablePositions != 0) {
                // the least significant bit that is 1
                // pos = x & (~x + 1) = x & -x;
                int position = availablePositions & -availablePositions;
                availablePositions ^= position; // remove this bit by xor
                // if diag1 is "???1?" and position is at last bit, so (diag | position) is "???11"
                // if they move along the diagnoal to next row, they will be "??11?"
                count = solve(n, row + 1, cols | position, (diag1 | position) << 1, (diag2 | position) >> 1, count);
            }
        }
        return count;
    }
}
