package leetcode.editor.cn;
 
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
// Related Topics 排序 数组 双指针 
// 👍 745 👎 0

import java.util.Arrays;

public class 颜色分类{
    public static void main(String[] args) {
        Solution solution = new 颜色分类().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {

        int len = nums.length;
        if (len < 2)
            return;
        int left = 0, right = len;
        int i = 0;
        while (i < right){
            if (nums[i] == 0){
                swap(nums, i, left);
                left++;
                i++;
            }else if (nums[i] == 2){
                right--;
                swap(nums, i, right);
            }else{
                i++;
            }
        }
    }

    public void swap(int[] nums, int index1, int index2){
        if (index1 != index2){
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}