// https://leetcode.com/problems/sort-list/
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find the middle node
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // seperate first half and second half
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        // merge them
        return merge(slow, fast);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode guard = new ListNode();
        ListNode cur = guard;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return guard.next;
    }
}
