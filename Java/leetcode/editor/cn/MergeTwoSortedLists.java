package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1407 👎 0

import java.util.LinkedList;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        Solution solution = new 合并两个有序链表().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            while (l1 != null || l2 != null) {
                int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                ListNode smallNode = val1 < val2 ? l1 : l2;
                cur.next = smallNode;
                cur = cur.next;
                if (smallNode == l1) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
            }

            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}