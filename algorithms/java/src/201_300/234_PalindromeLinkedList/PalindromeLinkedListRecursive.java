import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedListRecursive {
    private ListNode front;

    public boolean isPalindrome(ListNode head) {
        front = head;
        return recursive(head);
    }

    private boolean recursive(ListNode node) {
        if (node == null) {
            return true;
        }

        if (!recursive(node.next) || front.val != node.val) {
            return false;
        }
        front = front.next;
        return true;
    }
}
