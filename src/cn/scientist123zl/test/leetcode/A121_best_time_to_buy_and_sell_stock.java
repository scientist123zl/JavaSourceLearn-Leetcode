package cn.scientist123zl.test.leetcode;

/**
 * 6.10 买卖股票的最佳时机
 * 动态规划
 */
public class A121_best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        A121_best_time_to_buy_and_sell_stock a = new A121_best_time_to_buy_and_sell_stock();
        System.out.println(a.maxProfit(new int[]{7,6,4,3,1}));
    }
}
