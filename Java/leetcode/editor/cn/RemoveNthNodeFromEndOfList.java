package leetcode.editor.cn;
 
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1134 👎 0

import java.util.ArrayList;

public class 删除链表的倒数第N个节点{
    public static void main(String[] args) {
        Solution solution = new 删除链表的倒数第N个节点().new Solution();
         
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
 * }*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next != null){
            end = end.next;
            start = start.next;
        }

        start.next = start.next.next;
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}