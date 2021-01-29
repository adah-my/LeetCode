package leetcode.editor.cn;
 
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 184 👎 0

public class 有效的完全平方数{
    public static void main(String[] args) {
        Solution solution = new 有效的完全平方数().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, hight = num/2+1;
        while (low <= hight)
        {
            int mid = low + ((hight - low) >> 1);
            int target = num / mid;
            if (target == mid)
            {
                if (num % mid == 0)
                    return true;
                low = mid + 1;
            }
            else if (target < mid)
            {
                hight = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}