package leetcode.editor.cn;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 556 👎 0

import java.util.ArrayList;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        Solution solution = new 螺旋矩阵().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
            while (true) {
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[up][i]);
                }
                if (++up > down) {
                    break;
                }
                for (int i = up; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                if (--right < left) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                if (--down < up) {
                    break;
                }
                for (int i = down; i >= up; i--) {
                    ans.add(matrix[i][left]);
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