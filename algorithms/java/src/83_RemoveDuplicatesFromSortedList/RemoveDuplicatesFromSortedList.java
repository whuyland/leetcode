// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode guard = new ListNode();
        guard.next = head;
        ListNode cur = head;
        head = head.next;
        while (head != null) {
            if (cur.val != head.val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return guard.next;
    }
}
