package leetcode.editor.cn;
 
//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 268 👎 0

public class 螺旋矩阵 II{
    public static void main(String[] args) {
        Solution solution = new 螺旋矩阵 II().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int up = 0, down = n-1, left = 0, right = n-1;
        int number = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                ans[up][i] = number++;
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                ans[i][right] = number++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans[down][i] = number++;
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                ans[i][left] = number++;
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}