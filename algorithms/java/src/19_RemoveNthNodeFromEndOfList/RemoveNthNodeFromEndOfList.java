// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode guard = new ListNode();
        guard.next = head;
        ListNode fast = guard;
        ListNode slow = guard;
        for (int i = 0; i <= n; ++i) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return guard.next;
    }

    public ListNode removeNthFromEndI(ListNode head, int n) {
        ListNode guard = new ListNode();
        guard.next = head;

        ListNode slow = guard;
        ListNode fast = guard;
        int fastCnt = 0;
        int slowCnt = 0;
        while (fast != null) {
            fast = fast.next;
            ++fastCnt;
            if (fast != null) {
                fast = fast.next;
                ++fastCnt;
            }
            slow = slow.next;
            ++slowCnt;
        }
        System.out.println(fastCnt);
        System.out.println(slowCnt);
        // after loop, length = fastCnt - 1, we are looking for xth = length + 1 - n = fastCnt - n
        // we need only to step forward x - 1 = fastCnt - n - 1 steps from guard to reach parent of xth
        int target = fastCnt - n - 1;
        System.out.println(target);
        if (slowCnt > target) {
            slowCnt = 0;
            slow = guard;
        }
        while (slowCnt != target) {
            slow = slow.next;
            ++slowCnt;
        }

        slow.next = slow.next.next;
        return guard.next;
    }
}
