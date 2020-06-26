package cn.scientist123zl.test.leetcode;

/**
 * 6.5 不同路径
 * 动态规划
 */
public class A63_unique_paths_ii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];//new dp[j] = old dp[j] + dp[j-1] //current cell = top cell + left cell
            }
        }
        return dp[width - 1];
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int[][] dp = new int[m][n];
//        for(int i = 0; i < m; i++) {
//            if(obstacleGrid[i][0] == 1){
//                dp[i][0] = 0;
//                break;
//            }else{
//                dp[i][0] = 1;
//            }
//        }
//        for(int i = 0; i < n; i++)  {
//            if(obstacleGrid[0][i] == 1){
//                dp[0][i] = 0;
//                break;
//            }else{
//                dp[0][i] = 1;
//            }
//        }
//        for(int i = 1; i < m; i++) {
//            for(int j = 1; j < n; j++){
//                if(obstacleGrid[i][j]==1) {
//                    dp[i][j] = 0;
//                }else {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                }
//            }
//        }
//        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        A63_unique_paths_ii a = new A63_unique_paths_ii();
        System.out.println(a.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
