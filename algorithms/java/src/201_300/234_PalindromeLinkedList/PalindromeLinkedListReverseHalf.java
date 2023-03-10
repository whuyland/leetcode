// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedListReverseHalf {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        fast = slow.next;
        while (fast != null && head.val == fast.val) {
            fast = fast.next;
            head = head.next;
        }
        slow.next = reverse(slow.next);
        return fast == null;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = head;
        ListNode node = head.next;
        while (node != null) {
            head.next = node.next;
            node.next = tail;
            tail = node;
            node = head.next;
        }
        return tail;
    }
}
