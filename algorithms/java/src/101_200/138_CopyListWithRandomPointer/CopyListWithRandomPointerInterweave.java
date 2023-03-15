// https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointerInterweave {
    // insert copied node next to origin node
    public RandomNode copyRandomList(RandomNode head) {
        RandomNode guard = new RandomNode(0);
        guard.next = head;
        while (head != null) {
            RandomNode copy = new RandomNode(head.val);
            copy.next = head.next;
            head.next = copy;
            head = copy.next;
        }
        head = guard.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        // restore the list order of origin and copy
        head = guard.next;
        RandomNode prev = guard;
        while (head != null) {
            prev.next = head.next;
            prev = prev.next;
            head.next = prev.next;
            head = head.next;
        }
        return guard.next;
    }
}
