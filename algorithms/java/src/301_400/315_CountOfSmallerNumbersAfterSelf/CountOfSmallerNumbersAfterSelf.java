import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountOfSmallerNumbersAfterSelf {
    // https://leetcode.com/problems/count-of-smaller-numbers-after-self/solutions/76584/mergesort-solution/

    // if we use stable sort to sort the number in increasing order,
    // for nums[i], counts[i] is the number of elements in range (i, n) that is smaller than nums[i],
    // they will be put ahead nums[i] in the final result
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Node[] nodes = new Node[n];
        Node[] tmp = new Node[n];
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i, nums[i]);
            ret.add(0);
        }
        sort(nodes, tmp, 0, n, ret);
        return ret;
    }

    private void sort(Node[] nodes, Node[] tmp, int start, int end, List<Integer> ret) {
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        sort(nodes, tmp, start, mid, ret);
        sort(nodes, tmp, mid, end, ret);
        System.arraycopy(nodes, start, tmp, start, end - start);

        int i = start;
        int j = mid;

        while (i < mid || j < end) {
            // combine the single loop together:
            // if there are no elements in right part,
            // or there are elements in left part and is smaller-equal than right
            if ((j == end) || (i < mid && tmp[i].val <= tmp[j].val)) {
                // we will write out a value in left part,
                // we know that nodes in right part in range [mid, j) are smaller than current value
                // just add it to the answer
                int idx = tmp[i].idx;
                ret.set(idx, ret.get(idx) + j - mid);
                nodes[start++] = tmp[i++];
            } else {
                nodes[start++] = tmp[j++];
            }
        }
    }

    static class Node {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
