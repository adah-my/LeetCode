package leetcode.editor.cn;
 
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 123 👎 0

import com.jfinal.template.stat.ast.If;

import java.util.ArrayList;

public class N 叉树的层序遍历{
    public static void main(String[] args) {
        Solution solution = new N 叉树的层序遍历().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root){
            return res;
        }
        order(root, 0, res);
        return res;
    }
    public void order(Node node, int level, List<List<Integer>> res){
        if (node != null){
            if (res.size() <= level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (null != node.children){
                node.children.forEach(n -> {
                    order(n, level+1, res);
                });
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}