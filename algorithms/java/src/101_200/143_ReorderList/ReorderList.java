// https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);
        middle = reverse(middle);
        merge(head, middle);
    }

    // fist half has same nodes as list2 or one more
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return next;
    }

    private ListNode reverse(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }

        return node;
    }

    private void merge(ListNode list1, ListNode list2) {
        // use first node in list1 as guard
        // nodes in list1 is equal to list2 or one less
        ListNode cur = list1;
        list1 = list1.next;

        while (list2 != null) {
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;

            cur.next = list1;
            cur = cur.next;
            if (list1 != null) {
                list1 = list1.next;
            }
        }
    }
}
