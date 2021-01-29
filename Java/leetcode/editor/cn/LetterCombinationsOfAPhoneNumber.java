package leetcode.editor.cn;
 
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 1022 👎 0

import java.util.ArrayList;

public class 电话号码的字母组合{
    public static void main(String[] args) {
        Solution solution = new 电话号码的字母组合().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<char[]> list;
    ArrayList<String> ans;


    public List<String> letterCombinations(String digits) {
        list = getList();
        ans = new ArrayList<>();
        if ("".equals(digits)){
            return ans;
        }
        findConbination(digits, 0, "");
        return ans;
    }
    public void findConbination(String digits, int index, String s){
        if (index == digits.length()){
            ans.add(s);
            return;
        }
        Character c = digits.charAt(index);
        char[] letters = list.get( c - '0');
        for(char a : letters){
            findConbination(digits, index+1, s+a);
        }
    }

    private ArrayList<char[]> getList() {
        ArrayList<char[]> list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add(new char[]{'a','b','c'});
        list.add(new char[]{'d','e','f'});
        list.add(new char[]{'g','h','i'});
        list.add(new char[]{'j','k','l'});
        list.add(new char[]{'m','n','o'});
        list.add(new char[]{'p','q','r','s'});
        list.add(new char[]{'t','u','v'});
        list.add(new char[]{'w','x','y','z'});
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}