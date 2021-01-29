package leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [1,1,1]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 352 👎 0

import java.text.DateFormatSymbols;
import java.util.LinkedList;
import java.util.Queue;

public class 01矩阵{
public static void main(String[]args){
        Solution solution=new 01矩阵().new Solution();

        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 将所有的0添加进初始队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }
        // 广度优先队列
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k][0];
                int nj = j + dirs[k][1];
                if (ni >= 0 && ni < m&& nj >= 0 && nj < n && !seen[ni][nj]){
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni,nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}