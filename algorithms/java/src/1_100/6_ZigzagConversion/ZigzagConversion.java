// https://leetcode.com/problems/zigzag-conversion
class ZigzagConversion {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder(n);
        int sectionLength = (numRows - 1) * 2;

        // the pattern is repeated in every section,
        // therefore on any row, if it contains char at index x and y in the first section,
        // it will contain char at x + n * sectionLength and y + n * sectionLength,
        // which n is the increasing section number
        for (int i = 0; i < numRows; ++i) {
            int[] base;
            if (i == 0 || i == numRows - 1) {
                // the base index for 0th and (numRows - 1)th is 0 and numRows - 1
                // they each have only one element in first section
                base = new int[]{i};
            } else {
                // the other row have two elements if first section,
                // which satisfy i + j = sectionLength
                base = new int[]{i, sectionLength - i};
            }
            boolean finished = false;
            int sectionNum = 0;
            while (!finished) {
                for (int k : base) {
                    int index = k + sectionNum;
                    if (index < n) {
                        sb.append(s.charAt(index));
                    } else {
                        finished = true;
                        break;
                    }
                }
                // this is a trick to avoid calculate sectionNum * sectionLength
                sectionNum += sectionLength;
            }
        }
        return sb.toString();
    }
}
