package cn.scientist123zl.test.leetcode;

import java.util.Arrays;

/**
 * 6.26 最长上升子序列
 * 动态规划
 */
public class A300_longest_increasing_subsequence {
    //1.定义状态：dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度。
    //2.状态转移：遍历到 nums[i] 时，需要把下标 i 之前的所有的数都看一遍；
    //只要 nums[i] 严格大于在它位置之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列；
    //因此，dp[i] 就等于下标 i 之前严格小于 nums[i] 的状态值的最大者 +1。
    //3.考虑初始化：dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
    //4.考虑输出：最大的dp输出

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) {
            return 0;
        }
        int[] dp = new int [n];
        Arrays.fill(dp, 1);//非常重要

        for(int i = 1; i < n; i++) {
            int temp = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[j] >= temp){
                    dp[i] = dp[j] + 1;
                    temp = dp[j];
                }
            }
        }
        int res = 0;
        for(int k = 0; k < n; k++) {
            res = Math.max(res, dp[k]);
        }
        return res;
    }

    public static void main(String[] args) {
        A300_longest_increasing_subsequence a = new A300_longest_increasing_subsequence();
        System.out.println(a.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
