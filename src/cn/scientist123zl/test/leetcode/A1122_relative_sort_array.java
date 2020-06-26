package cn.scientist123zl.test.leetcode;

import java.util.Arrays;

/**
 * 6.24 数组的相对排序
 * 排序
 */
public class A1122_relative_sort_array {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;

    }

    public static void main(String[] args) {
        A1122_relative_sort_array a = new A1122_relative_sort_array();
        System.out.println(Arrays.toString(a.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
    }
}
