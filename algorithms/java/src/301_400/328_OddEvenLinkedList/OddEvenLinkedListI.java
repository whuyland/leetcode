// https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedListI {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode guard = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode cur = even.next;
        boolean moveNode = true;
        while (cur != null) {
            if (moveNode) {
                even.next = cur.next;
                cur.next = odd.next;
                odd.next = cur;
                odd = cur;
                cur = even.next;
            } else {
                even = cur;
                cur = cur.next;
            }
            moveNode = !moveNode;
        }
        return guard;
    }
}
