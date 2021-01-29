package leetcode.editor.cn;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 633 👎 0

import io.vertx.core.cli.annotations.Summary;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        Solution solution = new 最接近的三数之和().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int left, right;
            Arrays.sort(nums);
            int ans = nums[0]+nums[1]+nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    int curAbs = nums[i] + nums[left] + nums[right];
//                    while (nums[left] == nums[left + 1] && left + 1 < right) {
//                        left++;
//                    }
//                    while (nums[right] == nums[right - 1] && right - 1 > left) {
//                        right--;
//                        continue;
//                    }
                    if (Math.abs(curAbs - target) < Math.abs(ans - target)) {
                        ans = curAbs;
                    }
                    if (curAbs > target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}