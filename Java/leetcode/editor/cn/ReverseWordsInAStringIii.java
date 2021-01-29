package leetcode.editor.cn;
 
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 255 👎 0

public class 反转字符串中的单词 III{
    public static void main(String[] args) {
        Solution solution = new 反转字符串中的单词 III().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] splits = s.split(" ");
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String str = splits[i];
            for (int index = str.length()-1; index >= 0 ; index--) {
                string.append(str.charAt(index));
            }
            if (i != splits.length-1){
                string.append(" ");
            }
        }
        return string.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}