/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode NewHead=new ListNode(0);//给链表加入头结点(哑结点)NewHead
        NewHead.next=head;//头结点始终指向链表中的第一个节点
        ListNode pre,cur;
        while(head!=null&&head.next!=null){
            //当前节点的值小于下一个节点的值时（满足链表升序条件），避免排序操作，直接进行下一轮循环
            if(head.val<=head.next.val){
                head=head.next;
                continue;
            }
            pre=NewHead;
            //下一个节点的值小于当前节点的值，从头结点开始找出第一个大于等于下一个节点（head.next）值的前一个节点，进行插入删除操作，主要是对指针的操作
            while(pre.next.val<head.next.val){
                pre=pre.next;
            }
            cur=head.next;//对指针的操作建议画一下图，cur指向下一个节点（要操作的节点）
            head.next=cur.next;//使当前节点指向下下一个节点
            cur.next=pre.next;//使cur节点指向pre的下一个节点，即cur节点小于等于的那个节点
            pre.next=cur;//使pre节点指向cur节点
        }
        return NewHead.next;//将结果返回
    }
}