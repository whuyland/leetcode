// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInALinkedListI {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        node = node.next;
        while (node.next != null) {
            prev.val = node.val;
            prev = prev.next;
            node = node.next;
        }
        prev.next = null;
        prev.val = node.val;
    }
}
