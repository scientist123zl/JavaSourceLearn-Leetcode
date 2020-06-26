package cn.scientist123zl.test.leetcode;

/**
 * 6.25 编辑距离
 * 动态规划
 */
public class A72_edit_distance {
    public int minDistance(String word1, String word2) {
        //1.BFS双端
        //2,dp
        // dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
        // 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
        // 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        // 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        A72_edit_distance a = new A72_edit_distance();
        System.out.println(a.minDistance("horse","ros"));
    }
}
