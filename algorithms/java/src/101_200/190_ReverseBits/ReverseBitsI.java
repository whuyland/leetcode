// https://leetcode.com/problems/reverse-bits/
public class ReverseBitsI {
    // you need to treat n as an unsigned value
    public int reverseBits(int n) {
        int l = 1 << 31;
        int r = 1;
        int ret = 0;
        for (int i = 0; i < 16; ++i) {
            if ((n & l) != 0) {
                ret |= r;
            }
            if ((n & r) != 0) {
                ret |= l;
            }
            l = l >>> 1;
            r = r << 1;
        }
        return ret;
    }
}
