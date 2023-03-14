import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] rightBorder = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            rightBorder[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ret = new LinkedList<>();
        int i = 0;
        while (i < n) {
            int left = i;
            int right = i;
            while (i <= right) {
                right = Math.max(right, rightBorder[s.charAt(i) - 'a']);
                ++i;
            }
            ret.add(i - left);
        }
        return ret;
    }
}
