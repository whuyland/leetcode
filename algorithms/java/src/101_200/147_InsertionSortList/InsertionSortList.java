// https://leetcode.com/problems/insertion-sort-list/
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode guard = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode node = findInsertPoint(guard, head.val);
            ListNode next = head.next;
            insertAfter(node, head);
            head = next;
        }
        return guard.next;
    }

    private ListNode findInsertPoint(ListNode guard, int val) {
        while (guard.next != null && guard.next.val < val) {
            guard = guard.next;
        }
        return guard;
    }

    private void insertAfter(ListNode head, ListNode node) {
        node.next = head.next;
        head.next = node;
    }
}
