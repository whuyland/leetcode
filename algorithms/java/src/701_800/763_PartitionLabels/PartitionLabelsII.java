import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
public class PartitionLabelsII {
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
        int[] labels = new int[n];
        int label = 1;
        for (int[] pair : cnt) {
            if (pair[0] == -1 && pair[1] == -1) {
                continue;
            }
            int left = pair[0];
            int right = pair[1] == -1 ? pair[0] : pair[1];
            int j = left - 1;
            while (labels[left] != 0 && j >= 0 && labels[j] == labels[left]) {
                labels[j--] = label;
            }
            j = right + 1;
            while (labels[right] != 0 && j < n && labels[j] == labels[right]) {
                labels[j++] = label;
            }
            j = left;
            while (j <= right) {
                labels[j++] = label;
            }
            ++label;
        }
        List<Integer> ret = new LinkedList<>();
        int prev = labels[0];
        int num = 1;
        for (int i = 1; i < n; ++i) {
            if (prev == labels[i]) {
                ++num;
            } else {
                ret.add(num);
                prev = labels[i];
                num = 1;
            }
        }
        ret.add(num);
        return ret;
    }
}
