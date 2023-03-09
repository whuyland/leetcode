import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
public class LRUCache {
    static public class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        CacheNode() {
        }
    }

    private final Map<Integer, CacheNode> contents;
    private final CacheNode head;
    private final CacheNode tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.contents = new HashMap<>();
        this.head = new CacheNode();
        this.tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!contents.containsKey(key)) {
            return -1;
        }
        return touch(contents.get(key)).value;
    }

    public void put(int key, int value) {
        if (contents.containsKey(key)) {
            touch(contents.get(key)).value = value;
            return;
        }
        if (contents.size() == capacity) {
            contents.remove(remove(tail.prev).key);
        }
        CacheNode node = new CacheNode(key, value);
        contents.put(key, node);
        insert(node);
    }

    private CacheNode touch(CacheNode node) {
        if (head.next != node) {
            remove(node);
            insert(node);
        }
        return node;
    }

    private void insert(CacheNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private CacheNode remove(CacheNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return node;
    }
}
