package leetcode.editor.cn;
 
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 537 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 字母异位词分组{
    public static void main(String[] args) {
        Solution solution = new 字母异位词分组().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null){
            return null;
        }
        int[] prims = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs){
            long key = 1;
            for (int i = 0; i < str.length(); i++) {
                key *= prims[str.charAt(i) - 'a'];
            }
            if (map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List<String> element = new ArrayList<>();
                element.add(str);
                map.put(key, element);
            }
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}