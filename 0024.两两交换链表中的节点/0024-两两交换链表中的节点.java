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
    /**
    * 递归三部曲模板：
    * 1. 找终止条件 
    * 2. 找到返回值
    * 3. 本级递归应该做什么
    */
    public ListNode swapPairs(ListNode head) {
        //1. 递归条件为：当链表仅剩一个节点或者没有节点时，不进行交换
        if (head == null || head.next == null) {
            return head;
        }
        //3. 本级递归应该交换head和next的位置，其中swapPairs(next.next)为已处理好的链表
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //2. 返回给上一级递归已经处理好的链表
        return next;
    }
}