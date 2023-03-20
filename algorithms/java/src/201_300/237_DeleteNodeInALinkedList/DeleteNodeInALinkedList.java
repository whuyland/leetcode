// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        // we can just delete next node, and put its value here
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
