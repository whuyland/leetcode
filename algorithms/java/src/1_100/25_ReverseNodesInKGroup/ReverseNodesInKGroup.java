// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode guard = new ListNode();
        guard.next = head;
        ListNode cur = guard;

        while (true) {
            // check if there are k elements left
            ListNode n = cur;
            boolean enough = true;
            for (int i = 0; i < k; ++i) {
                n = n.next;
                if (n == null) {
                    enough = false;
                    break;
                }
            }
            if (!enough) {
                break;
            }
            ListNode tail = cur.next;
            for (int i = 1; i < k; ++i) {
                ListNode target = tail.next;
                tail.next = target.next;
                target.next = cur.next;
                cur.next = target;
            }
            cur = tail;
        }

        return guard.next;
    }
}
