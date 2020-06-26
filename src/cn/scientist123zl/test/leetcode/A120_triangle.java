package cn.scientist123zl.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6.6 三角形最小路径和
 * 动态规划
 * 递归
 */
public class A120_triangle {
    //1.递归 2^n
    //2.dp
    //a.重复性（分治） problem(i,j) = min(sub(i+1,j) ,sub(i+1,j+1))+ a[i,j]
    // b.定义状态数组  f[i,j]
    //c.dp方程   f[i,j] = min(f[]i+1,j] ,f[]i+1,j+1])+ a[i,j]
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0) {
//            return 0;
//        }
//
//        int m = triangle.size();
//        int[][] dp = new int[m+1][m+1];
//        for(int i = m-1; i >= 0; --i) {
//            for(int j = 0; j < triangle.get(i).size(); ++j) {
//                dp[i][j] = Math.min(dp[i+1][j] , dp[i+1][j+1]) + triangle.get(i).get(j);
//            }
//        }
//        return dp[0][0];
//    }


    //递归
    int row;
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        row = triangle.size();
        memo = new Integer[row][row];
        return helper(0,0,triangle);
    }

    private int helper(int level, int c, List<List<Integer>> triangle) {
        System.out.println("level="+level+"c="+c);
        if(memo[level][c] != null){
            return memo[level][c];
        }
        if(level == row -1) {
            return memo[level][c] = triangle.get(level).get(c);
        }

        int left = helper(level+1,c,triangle);
        int right = helper(level+1,c+1,triangle);
        return memo[level][c] = Math.min(left,right) +triangle.get(level).get(c);
    }

    public static void main(String[] args) {
        A120_triangle a = new A120_triangle();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(a.minimumTotal(list));
    }
}
