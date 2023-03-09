// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = len(headA);
        int n = len(headB);
        int diff = m - n;
        if (diff < 0) {
            headB = move(headB, -diff);
        } else {
            headA = move(headA, diff);
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int len(ListNode node) {
        int cnt = 0;
        while (node != null) {
            ++cnt;
            node = node.next;
        }
        return cnt;
    }

    private ListNode move(ListNode node, int n) {
        for (int i = 0; i < n; ++i) {
            node = node.next;
        }
        return node;
    }
}
