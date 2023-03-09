// https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode guard = new ListNode(0, head);
        ListNode prev = guard;
        for (int i = 1; i < left; ++i) {
            prev = prev.next;
        }
        head = prev.next;
        for (int i = 0; i < right - left; ++i) {
            ListNode prevNext = prev.next;
            prev.next = head.next;
            head.next = head.next.next;
            prev.next.next = prevNext;
        }
        return guard.next;
    }
}
