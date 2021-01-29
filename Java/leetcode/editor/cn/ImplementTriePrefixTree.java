package leetcode.editor.cn;
 
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 494 👎 0

import sun.jvm.hotspot.ui.tree.BooleanTreeNodeAdapter;

import java.util.ArrayList;

public class 实现 Trie (前缀树){
    public static void main(String[] args) {
        Solution solution = new 实现 Trie (前缀树)().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    class TireNode{
        private boolean isEnd;
        TireNode[] next;

        public TireNode(){
            isEnd = false;
            next = new TireNode[26];
        }
    }

    private TireNode root;

    public Trie(){
        root = new TireNode();
    }

    public void insert(String word){
        TireNode node = root;
        for (char c : word.toCharArray()){
            if (node.next[c - 'a'] == null){
                node.next[c - 'a'] = new TireNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        TireNode node = root;
        for (char c : word.toCharArray())
        {
            node = node.next[c - 'a'];
            if (node == null){
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix){
        TireNode node = root;
        for (char c : prefix.toCharArray())
        {
            node = node.next[c - 'a'];
            if (node == null){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}