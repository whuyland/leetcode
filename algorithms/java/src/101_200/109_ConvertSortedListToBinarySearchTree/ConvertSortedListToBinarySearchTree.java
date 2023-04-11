// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prevMiddle = findPrevMiddle(head);
        ListNode middle = prevMiddle.next;
        prevMiddle.next = null;
        TreeNode node = new TreeNode(middle.val,
                sortedListToBST(head),
                sortedListToBST(middle.next));
        prevMiddle.next = middle;
        return node;
    }

    // @pre: head and head.next is not null
    private ListNode findPrevMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
