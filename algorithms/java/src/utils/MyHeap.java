import java.util.Arrays;
import java.util.Random;

public class MyHeap {
    static private final int defaultCapacity = 10;

    public MyHeap(int capacity) {
        nums = new int[Math.max(capacity, defaultCapacity) + 1];
    }

    public MyHeap() {
        this(defaultCapacity);
    }

    public void offer(int val) {
        if (top == nums.length) {
            nums = Arrays.copyOf(nums, nums.length * 2 - 1);
        }
        nums[top++] = val;
        moveUp(top - 1);
    }

    private Integer poll() {
        if (top == 1) {
            return null;
        }

        Integer ret = nums[1];
        --top;
        swap(nums, 1, top);
        moveDown(1);
        return ret;
    }

    private void moveDown(int i) {
        int left = 2 * i;
        int right = left + 1;

        if (left >= top) {
            return;
        }
        int min = left;
        if (right < top && nums[right] < nums[left]) {
            min = right;
        }
        if (nums[min] < nums[i]) {
            swap(nums, min, i);
            moveDown(min);
        }
    }

    private void moveUp(int i) {
        if (i <= 1) {
            return;
        }
        int parent = i / 2;
        if (nums[parent] > nums[i]) {
            swap(nums, parent, i);
            moveDown(parent);
        }
    }

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    private int[] nums;
    private int top = 1;

    public static void main(String[] args) {
        int[] test = new int[100];
        for (int i = 0; i < 100; ++i) {
            test[i] = i;
        }
        for (int i = 0; i < 100; ++i) {
            shuffle(test);
            MyHeap myHeap = new MyHeap();
            for (int k : test) {
                myHeap.offer(k);
            }
            for (int j = 0; j < 100; ++j) {
                assert myHeap.poll() == j;
            }
        }
    }

    static public void shuffle(int[] job) {
        int n = job.length;
        Random r = new Random();
        for (int i = 0; i < n; ++i) {
            swap(job, i, r.nextInt(n - i));
        }
    }
}
