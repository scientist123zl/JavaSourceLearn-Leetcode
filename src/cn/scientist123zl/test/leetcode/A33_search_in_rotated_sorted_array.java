package cn.scientist123zl.test.leetcode;

/**
 * 6.4 搜索旋转排序数组
 */
/*当[0, mid] 序列是升序: nums[0] <= nums[mid], 当target > nums[mid] || target < nums[0] ,则向后规约
当[0, mid] 序列存在旋转位: nums[0] > nums[mid],当target < nums[0] && target > nums[mid],则向后规约
当然其他其他情况就是向前规约了*/
public class A33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length -1;
        while(l <= h) {
           int mid = l + (h - l) / 2;
           if(nums[mid] == target) return mid;
           if( (nums[mid] < target || nums[0] > target) && nums[0] <= nums[mid]) {
               l = mid + 1;
           }else if(nums[mid] < target && nums[0] > target) { //则一定nums[0] > nums[mid]
               l = mid + 1;
           }else{
               h = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        A33_search_in_rotated_sorted_array a =new A33_search_in_rotated_sorted_array();
        System.out.println(a.search(new int[]{1,3},3));
    }

}
