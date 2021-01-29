package leetcode.editor.cn;
 
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1447 👎 0

import org.elasticsearch.search.dfs.DfsPhase;

import java.util.ArrayList;

public class 括号生成{
    public static void main(String[] args) {
        Solution solution = new 括号生成().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr){
        if (left == 0 && right == 0){ // 左右括号都无剩余了，终止递归
            res.add(curStr);
            return;
        }
        if (left > 0){ // 如果左括号还有剩余，可以继续拼接左括号
            dfs(left-1, right, curStr+"(");
        }
        if (right > left){ // 如果右括号剩余多于左括号，可以拼接右括号
            dfs(left, right-1, curStr+")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}