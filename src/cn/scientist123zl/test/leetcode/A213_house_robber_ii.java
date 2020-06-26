package cn.scientist123zl.test.leetcode;

import java.util.Arrays;

/**
 * 6.8 打家劫舍
 * 动态规划
 */
public class A213_house_robber_ii {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        A213_house_robber_ii a = new A213_house_robber_ii();
        System.out.println(a.rob(new int[]{1,2,3,1}));
    }
}
