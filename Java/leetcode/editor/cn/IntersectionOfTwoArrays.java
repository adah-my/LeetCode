package leetcode.editor.cn;
 
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 301 👎 0


import java.util.*;

public class 两个数组的交集{
    public static void main(String[] args) {
        Solution solution = new 两个数组的交集().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer>  res = new LinkedList<>();
        HashMap<Integer,Boolean> hash = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!hash.containsKey(nums1[i])){
                hash.put(nums1[i],false);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hash.containsKey(nums2[i])){
                hash.put(nums2[i], true);
            }
        }
        Iterator<Map.Entry<Integer, Boolean>> iterator = hash.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Boolean> entry = iterator.next();
            if (entry.getValue()){
                res.add(entry.getKey());
            }
        }
        int[] ans = new int[res.size()];
        int index = 0;
        for (int num : res){
            ans[index++] = num;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}