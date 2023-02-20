// https://leetcode.com/problems/valid-number/
// use DFA defined in: https://leetcode.com/problems/valid-number/solutions/23728/a-simple-solution-in-python-based-on-dfa/
public class ValidNumberDFA {
    static private final int[][] machine = {
            {0, 0, 0, 0}, // invalid
            {3, 2, 4, 0}, // 1
            {3, 0, 4, 0}, // 2
            {3, 0, 5, 6}, // 3
            {5, 0, 0, 0}, // 4
            {5, 0, 0, 6}, // 5
            {8, 7, 0, 0}, // 6
            {8, 0, 0, 0}, // 7
            {8, 0, 0, 0} // 8
    };

    public boolean isNumber(String s) {
        int state = 1;
        int sIndex = 0;
        while (sIndex < s.length()) {
            int lookupIndex = getIndex(s, sIndex);
            if (lookupIndex == -1) {
                return false;
            }
            state = machine[state][lookupIndex];
            if (state == 0) {
                return false;
            }
            ++sIndex;
        }
        return state == 3 || state == 5 || state == 8;
    }

    private int getIndex(String s, int i) {
        int c = s.charAt(i);
        if (c >= '0' && c <= '9') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == '.') {
            return 2;
        }
        if (c == 'e' || c == 'E') {
            return 3;
        }
        return -1;
    }
}
