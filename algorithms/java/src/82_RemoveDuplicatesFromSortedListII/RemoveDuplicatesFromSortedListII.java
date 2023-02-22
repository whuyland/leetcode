// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode guard = new ListNode();
        ListNode cur = guard;
        ListNode prev = null;
        while (head != null) {
            if (prev == null || prev.val != head.val) {
                if (head.next == null || head.val != head.next.val) {
                    cur.next = head;
                    cur = cur.next;
                }
            }
            prev = head;
            head = head.next;
        }
        cur.next = null;
        return guard.next;
    }
}
