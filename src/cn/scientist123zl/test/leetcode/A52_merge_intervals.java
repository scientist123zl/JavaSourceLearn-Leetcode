package cn.scientist123zl.test.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 6.24 合并区间
 * 排序
 */
public class A52_merge_intervals {
    public int[][] merge(int[][] intervals) {
        int length=intervals.length;
        if(length<=1)
            return intervals;

        int[] start = new int[length];
        int[] end = new int[length];
        for(int i=0;i<length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex=0;
        int endIndex=0;
        List<int[]> result = new LinkedList<>();
        while(endIndex<length){
            //as endIndex==length-1 is evaluated first, start[endIndex+1] will never hit out of index
            if(endIndex==length-1 || start[endIndex+1]>end[endIndex]){
                result.add(new int[]{start[startIndex],end[endIndex]});
                startIndex=endIndex+1;
            }
            endIndex++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        A52_merge_intervals a = new A52_merge_intervals();
        System.out.println(Arrays.deepToString(a.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10}
        })));
    }

}
