import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteGetRandomO1 {
    private final Random rand;
    private int[] nums;
    private final Map<Integer, Integer> indices;
    private int cap;
    private int top;

    public InsertDeleteGetRandomO1() {
        rand = new Random();
        indices = new HashMap<>();

        cap = 10;
        nums = new int[cap];
        top = 0;
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        indices.put(val, top);
        if (top == cap) {
            cap *= 2;
            nums = Arrays.copyOf(nums, cap);
        }
        nums[top++] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }

        int index = indices.remove(val);
        --top;

        if (index != top) {
            indices.put(nums[top], index);
            nums[index] = nums[top];
        }
        return true;
    }

    public int getRandom() {
        return nums[rand.nextInt(top)];
    }
}
