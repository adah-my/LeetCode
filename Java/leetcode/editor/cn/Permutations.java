package leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1025 👎 0

import com.jfinal.core.paragetter.IntegerGetter;

import java.util.ArrayList;
import java.util.Collections;

public class 全排列 {
    public static void main(String[] args) {
        Solution solution = new 全排列().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> output = new ArrayList<>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, ans, 0);
            return ans;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> ans, int first) {
            if (first == n) {
                ans.add(new ArrayList<>(output));
            }
            for (int i = first; i < n; i++) {
                Collections.swap(output, first, i);
                backtrack(n, output, ans, first + 1);
                Collections.swap(output, first, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}