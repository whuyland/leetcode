import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class LargestNumberI {
    static class Node implements Comparable<Node> {
        long val;
        long mask;

        Node(long value) {
            this.val = value;
            calcMask(value);
        }

        private void calcMask(long value) {
            mask = 1L;
            while (value != 0) {
                mask *= 10;
                value /= 10;
            }
        }

        public int compareTo(Node other) {
            if (val == 0) {
                return 1;
            }
            if (other.val == 0) {
                return -1;
            }

            long a = val * other.mask + other.val;
            long b = other.val * mask + val;
            return (int) (b - a);
        }
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(nums[i]);
        }
        Arrays.sort(nodes);
        if (nodes[0].val == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.val);
        }
        return sb.toString();
    }
}
