import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycleSlowFastPointers {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
