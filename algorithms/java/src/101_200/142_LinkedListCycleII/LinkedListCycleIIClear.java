// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleIIClear {
    public ListNode detectCycle(ListNode head) {
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode slow = guard;
        ListNode fast = guard;


        // x: non-cycle length
        // y: cycle-start to meet-point
        // z: meet-point back to cycle-start
        // slow moves: x + y
        // fast moves: x + y + y + z, and is twice of slow
        // 2 * (x + y) = x + 2y + z
        // ==> x = z
        // if fast start from meet point, and slow from guard, they will meet at cycle-start

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }

        slow = guard;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
