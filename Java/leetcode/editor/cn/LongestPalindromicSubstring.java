package leetcode.editor.cn;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2954 👎 0

public class 最长回文子串 {
    public static void main(String[] args) {
        Solution solution = new 最长回文子串().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null && "".equals(s)) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expendAroundCenter(s, i, i);
                int len2 = expendAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expendAroundCenter(String s, int start, int end) {
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                --start;
                ++end;
            }
            return end - start - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}