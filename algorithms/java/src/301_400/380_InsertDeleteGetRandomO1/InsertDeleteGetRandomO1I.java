import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteGetRandomO1I {
    private final Random rand;
    private final List<Integer> nums;
    private final Map<Integer, Integer> indices;
    private int cap;
    private int top;

    public InsertDeleteGetRandomO1I() {
        rand = new Random();
        nums = new ArrayList<>();
        indices = new HashMap<>();
        cap = 0;
        top = 0;
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        indices.put(val, top);
        if (top == cap) {
            nums.add(val);
            ++cap;
            ++top;
        } else {
            nums.set(top++, val);
        }
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.remove(val);
        --top;
        if (index != top) {
            int topVal = nums.get(top);
            indices.put(topVal, index);
            nums.set(index, topVal);
        }
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(top));
    }
}
