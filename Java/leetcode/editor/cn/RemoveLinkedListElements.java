package leetcode.editor.cn;
 
//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 491 👎 0

public class 移除链表元素{
    public static void main(String[] args) {
        Solution solution = new 移除链表元素().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        pre.next = head;
        ListNode cur = pre;
        while (cur != null && cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}