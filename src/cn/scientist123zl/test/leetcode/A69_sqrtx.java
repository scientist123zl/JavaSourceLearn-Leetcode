package cn.scientist123zl.test.leetcode;

/**
 * 6.4 sqrt
 * 二分查找
 */
public class A69_sqrtx {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        A69_sqrtx a = new A69_sqrtx();
        System.out.println(a.mySqrt(8));
    }
}
