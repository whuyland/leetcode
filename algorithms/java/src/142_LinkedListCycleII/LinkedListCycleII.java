// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode slow = guard;
        ListNode fast = guard;

        // when fast and slow meet, fast will move more steps than slow, which is the length of the cycle,
        // and also fast is twice slow, we can just record the slow move steps
        int cnt = 0;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            ++cnt;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }

        // if we first move a pointer cycle step ahead,
        // then let another pointer start from first,
        // then both of them move at the speed, they will meet at begin of cycle
        fast = guard;
        for (int i = 0; i < cnt; ++i) {
            fast = fast.next;
        }
        slow = guard;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
