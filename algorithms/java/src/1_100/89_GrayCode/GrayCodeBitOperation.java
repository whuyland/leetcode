import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/gray-code/
public class GrayCodeBitOperation {
    public List<Integer> grayCode(int n) {
        // https://leetcode.cn/problems/gray-code/solution/ge-lei-bian-ma-by-leetcode-solution-cqi7/
        // i can be odd or even:
        // if i is odd, then i >> 1 and (i + 1) >> 1 are the same
        // and the i ^ (x >> 1) and (i + 1) ^ ((i + 1) >> 1) will only differs one bie
        // with some drawing, the even case is also the same
        List<Integer> ret = new ArrayList<>(n);
        for (int i = 0; i < 1 << n; ++i) {
            ret.add(i ^ (i >> 1));
        }
        return ret;
    }
}
