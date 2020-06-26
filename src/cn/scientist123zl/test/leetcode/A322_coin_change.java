package cn.scientist123zl.test.leetcode;

/**
 * 6.6 零钱兑换
 * 动态规划
 */
public class A322_coin_change {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;

        while(++sum<=amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin] + 1;
                    if (min < 0 || temp < min)
                        min = temp;
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        A322_coin_change a = new A322_coin_change();
        System.out.println(a.coinChange(new int[]{1,2,5},11));
    }
}
