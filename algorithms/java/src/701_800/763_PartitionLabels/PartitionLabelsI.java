import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
public class PartitionLabelsI {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[][] cnt = new int[26][2];
        for (int[] row : cnt) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (cnt[index][0] == -1) {
                cnt[index][0] = i;
            } else {
                cnt[index][1] = i;
            }
        }

        List<Integer> ret = new LinkedList<>();
        int i = 0;
        while (i < n) {
            int left = i;
            int right = i;
            while (i <= right) {
                right = Math.max(right, cnt[s.charAt(i) - 'a'][1]);
                ++i;
            }
            ret.add(i - left);
        }
        return ret;
    }
}
