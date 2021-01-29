package leetcode.editor.cn;
 
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 733 👎 0

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

public class 二叉树的层序遍历{
    public static void main(String[] args) {
        Solution solution = new 二叉树的层序遍历().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        order(root, 0, res);
        return res;
    }

    public void order(TreeNode root, int level, List<List<Integer>> res)
    {
        if (root == null)
            return;
        if (res.size() <= level)
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        order(root.left, level+1, res);
        order(root.right, level+1, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}