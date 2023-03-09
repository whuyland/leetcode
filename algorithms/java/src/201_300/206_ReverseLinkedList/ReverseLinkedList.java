// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = tail;
            tail = next;
        }
        return tail;
    }
}
