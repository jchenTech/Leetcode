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
    /*
    * 快慢指针解法：一趟扫描完成
    * 快指针先走n步，然后两个指针同时开始遍历，直到快指针的next为空时停止
    * 此时的慢指针停在要删除节点的前一个节点位置，slow.next=slow.next.next
    * 同时考虑到为了避免头节点的判断情况，我们通常采用一个哑节点
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1.新建一个哑巴节点，避免头节点的讨论情况
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        //2.fast节点先走n步
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        //3.当快指针的next为空时停止，此时慢指针走了len-1-n步，为倒数第n个节点的前一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}