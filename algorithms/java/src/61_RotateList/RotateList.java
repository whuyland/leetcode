// https://leetcode.com/problems/rotate-list/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode guard = new ListNode();
        guard.next = head;

        // two situations: k > totalLength or k <= totalLength
        ListNode node = guard;
        int cnt = 0;
        while (cnt < k && node != null) {
            node = node.next;
            ++cnt;
        }

        if (node == null) {
            // k > len
            k %= (cnt - 1); // cnt - 1 is to total node number
            node = guard;
            cnt = 0;
            while (cnt < k && node != null) {
                node = node.next;
                ++cnt;
            }
        }
        if (node.next == null) {
            // we reach the tail element, and k is length
            // we just do nothing
            return guard.next;
        }

        ListNode tail = guard;
        while (node.next != null) {
            node = node.next;
            tail = tail.next;
        }
        node.next = guard.next;
        guard.next = tail.next;
        tail.next = null;
        return guard.next;
    }
}
