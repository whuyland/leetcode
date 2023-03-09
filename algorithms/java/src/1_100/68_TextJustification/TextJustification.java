import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/text-justification/
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new LinkedList<>();

        int n = words.length;
        int cur = 0;
        StringBuilder sb = new StringBuilder();

        while (cur < n) {
            int left = cur;
            sb.setLength(0);
            sb.append(words[cur++]);
            int total = words[left].length();
            int gapNum = 0;
            while (cur < n && total + (gapNum + 1) + words[cur].length() <= maxWidth) {
                total += words[cur].length();
                ++gapNum;
                ++cur;
            }
            int blank = maxWidth - total;

            if (cur - left == 1) {
                sb.append(" ".repeat(blank));
                ret.add(sb.toString());
            } else {
                if (cur != n) {
                    for (int i = left + 1; i < cur; ++i) {
                        int gap = (blank + gapNum - 1) / gapNum;
                        sb.append(" ".repeat(gap)).append(words[i]);
                        blank -= gap;
                        --gapNum;
                    }
                } else {
                    for (int i = left + 1; i < cur; ++i) {
                        sb.append(" ").append(words[i]);
                    }
                    sb.append(" ".repeat(maxWidth - total - gapNum));
                }
                ret.add(sb.toString());
            }
        }
        return ret;
    }
}
