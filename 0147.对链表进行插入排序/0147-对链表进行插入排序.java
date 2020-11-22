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
        ListNode NewHead=new ListNode(0);//���������ͷ���(�ƽ��)NewHead
        NewHead.next=head;//ͷ���ʼ��ָ�������еĵ�һ���ڵ�
        ListNode pre,cur;
        while(head!=null&&head.next!=null){
            //��ǰ�ڵ��ֵС����һ���ڵ��ֵʱ�����������������������������������ֱ�ӽ�����һ��ѭ��
            if(head.val<=head.next.val){
                head=head.next;
                continue;
            }
            pre=NewHead;
            //��һ���ڵ��ֵС�ڵ�ǰ�ڵ��ֵ����ͷ��㿪ʼ�ҳ���һ�����ڵ�����һ���ڵ㣨head.next��ֵ��ǰһ���ڵ㣬���в���ɾ����������Ҫ�Ƕ�ָ��Ĳ���
            while(pre.next.val<head.next.val){
                pre=pre.next;
            }
            cur=head.next;//��ָ��Ĳ������黭һ��ͼ��curָ����һ���ڵ㣨Ҫ�����Ľڵ㣩
            head.next=cur.next;//ʹ��ǰ�ڵ�ָ������һ���ڵ�
            cur.next=pre.next;//ʹcur�ڵ�ָ��pre����һ���ڵ㣬��cur�ڵ�С�ڵ��ڵ��Ǹ��ڵ�
            pre.next=cur;//ʹpre�ڵ�ָ��cur�ڵ�
        }
        return NewHead.next;//���������
    }
}