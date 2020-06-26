package cn.scientist123zl.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5.28 全排列
 * 回溯
 */
public class A47_permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);//排序，让重复的数字相邻
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                //1.当i已被使用或者2.i>0且和前面一个数字相等前一个数字未使用，，，则跳过i
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        A47_permutations_II a = new A47_permutations_II();
        int[] nums = new int[]{1,3,1};
        System.out.println(a.permuteUnique(nums));
    }
}
