package cn.scientist123zl.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.27 全排列
 * 回溯
 */
public class A46_permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        A46_permutations test = new A46_permutations();
        int[] a =new int []{1,2,3};
        System.out.println(test.permute(a));
    }
}
