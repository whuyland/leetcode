// https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode guard = new ListNode();
        guard.next = head;
        ListNode cur = guard;
        while (cur.next != null && cur.next.next != null) {
            ListNode a = cur.next;
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            cur.next = b;
            cur = a;
        }
        return guard.next;
    }
}
