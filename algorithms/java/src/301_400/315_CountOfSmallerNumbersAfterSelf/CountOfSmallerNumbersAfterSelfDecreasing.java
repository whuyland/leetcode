import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountOfSmallerNumbersAfterSelfDecreasing {
    static class Node {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ret = new ArrayList<>();
        Node[] nodes = new Node[n];
        Node[] tmp = new Node[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i, nums[i]);
            ret.add(0);
        }
        solve(nodes, tmp, 0, n, ret);
        return ret;
    }

    // sort the elements in decreasing order,
    // before merge, the right part will be right to all left part elements
    // in the merge face:
    // if left head is larger, we know that all elements in right part is smaller it,
    // we can add the right remaining count to this left-head
    // if right head is larger or equal than left head, it doesn't count to the final result
    private void solve(Node[] nodes, Node[] tmp, int l, int r, List<Integer> ret) {
        if (r - l <= 1) {
            return;
        }
        int mid = (l + r) / 2;

        solve(nodes, tmp, l, mid, ret);
        solve(nodes, tmp, mid, r, ret);

        System.arraycopy(nodes, l, tmp, l, r - l);
        int i = l;
        int j = mid;

        while (i < mid && j < r) {
            if (tmp[i].val > tmp[j].val) {
                int idx = tmp[i].idx;
                ret.set(idx, ret.get(idx) + r - j);
                nodes[l++] = tmp[i++];
            } else {
                nodes[l++] = tmp[j++];
            }
        }
        while (i < mid) {
            nodes[l++] = tmp[i++];
        }
        while (j < r) {
            nodes[l++] = tmp[j++];
        }
    }
}
