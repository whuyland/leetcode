// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) {
            return null;
        }

        if (lo == hi - 1) {
            return lists[lo];
        }
        int mid = (lo + hi) / 2;
        ListNode left = merge(lists, lo, mid);
        ListNode right = merge(lists, mid, hi);
        ListNode guard = new ListNode();
        ListNode cur = guard;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return guard.next;
    }
}
