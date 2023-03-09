// https://leetcode.com/problems/single-number/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = 0;
        // x ^ x = 0, two equal number will cancel each other with xor
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }
}
