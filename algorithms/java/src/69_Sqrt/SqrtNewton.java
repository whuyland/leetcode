// https://leetcode.com/problems/sqrtx/
public class SqrtNewton {
    // Newton's Method
    public int mySqrt(int x) {
        long root = x;
        while (root * root > x) {
            root = (root + x / root) / 2;
        }
        return (int) root;
    }
}
