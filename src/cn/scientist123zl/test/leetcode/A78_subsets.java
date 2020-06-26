package cn.scientist123zl.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.28 子集
 * 回溯
 */
public class A78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null) return ans;
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        //terminator
        if(index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return ;
        }

        dfs(ans, nums, list, index + 1);//not pick the number at this index

        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);//pick the number at this index

        //restore state
        list.remove(list.size() - 1);

    }

    public static void main(String[] args) {
        A78_subsets a = new A78_subsets();
        int[] nums = new int[]{1,2,3};
        System.out.println(a.subsets(nums));
    }
}
