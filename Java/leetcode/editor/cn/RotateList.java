package leetcode.editor.cn;
 
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 376 👎 0

public class 旋转链表{
    public static void main(String[] args) {
        Solution solution = new 旋转链表().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (head.next == null || k == 0){
            return head;
        }
        ListNode pre = head;
        int len = 1;
        while (pre.next != null){
            pre = pre.next;
            len++;
        }
        pre.next = head;

        pre = head;
        int n = len-k%len-1;
        while (n-- > 0){
            pre = pre.next;
        }
        head = pre.next;
        pre.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}