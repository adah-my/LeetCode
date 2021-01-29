package leetcode.editor.cn;
 
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 424 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 两个数组的交集 II{
    public static void main(String[] args) {
        Solution solution = new 两个数组的交集 II().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> hash = new ArrayList<>();
        for (int num : nums1){
            hash.add(num);
        }
        for (int num : nums2){
            if (hash.contains(num)){
                res.add(num);
                hash.remove(Integer.valueOf(num));
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}