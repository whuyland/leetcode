// https://leetcode.com/problems/partition-list/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode guard = new ListNode();
        ListNode cur = guard;
        ListNode greaterGuard = new ListNode();
        ListNode greater = greaterGuard;

        while (head != null) {
            if (head.val < x) {
                cur.next = head;
                cur = cur.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        cur.next = greaterGuard.next;
        greater.next = null;
        return guard.next;
    }
}
