package leetcode.editor.cn;
 
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 528 👎 0

public class 字符串相乘{
    public static void main(String[] args) {
        Solution solution = new 字符串相乘().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] mul = new int[n1+n2];
        for (int i = n1-1; i >= 0; i--) {
            int ni = num1.charAt(i) - '0';
            for (int j = n2-1; j >= 0; j--) {
                int nj = num2.charAt(j) - '0';
                int tmul = ni*nj;
                tmul += mul[i+j+1];

                mul[i+j] += tmul/10;
                mul[i+j+1] = tmul%10;
            }
        }
        StringBuilder mulStr = new StringBuilder();
        for (int i = 0; i < mul.length; i++) {
            if (i == 0 && mul[i] == 0){
                continue;
            }
            mulStr.append(mul[i]);
        }
        return mulStr.toString();


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}