package leetcode.editor.cn;
 
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 898 👎 0

import java.util.ArrayList;

public class 子集{
    public static void main(String[] args) {
        Solution solution = new 子集().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums){
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(ans.get(i));
                newSub.add(num);
                ans.add(newSub);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}