import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] copy = new String[n];
        for (int i = 0; i < n; ++i) {
            copy[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(copy, (a, b) -> (b + a).compareTo(a + b));
        if (copy[0].equals("0")) {
            // it means all element are zero
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : copy) {
            sb.append(s);
        }
        return sb.toString();
    }
}
