import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int l = 0;
        int r = nums.size() - 1;
        while (l < r && nums.get(l) == nums.get(r)) {
            ++l;
            --r;
        }
        return r <= l;
    }
}
