package cn.scientist123zl.test.leetcode;

/**
 * 6.4  搜索二维矩阵
 * 二分查找
 */
public class A74_search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n -1;
        while(l <= r) {
            int mid = (l+r) >> 1;
            if(matrix[mid / n][mid % n] == target) return true;
            if(matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        A74_search_a_2d_matrix a =new A74_search_a_2d_matrix();
        System.out.println(a.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},3));
    }
}


