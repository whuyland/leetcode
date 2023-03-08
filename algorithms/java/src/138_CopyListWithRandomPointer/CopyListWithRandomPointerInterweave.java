// https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointerInterweave {
    // insert copied node next to origin node
    public Node copyRandomList(Node head) {
        Node guard = new Node(0);
        guard.next = head;
        while (head != null) {
            Node copy = new Node(head.val);
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
        Node prev = guard;
        while (head != null) {
            prev.next = head.next;
            prev = prev.next;
            head.next = prev.next;
            head = head.next;
        }
        return guard.next;
    }
}
