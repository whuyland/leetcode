// https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }


        odd.next = evenHead;
        return head;
    }
}
