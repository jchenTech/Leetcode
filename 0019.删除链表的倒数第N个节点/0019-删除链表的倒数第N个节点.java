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
    * ����ָ��ⷨ��һ��ɨ�����
    * ��ָ������n����Ȼ������ָ��ͬʱ��ʼ������ֱ����ָ���nextΪ��ʱֹͣ
    * ��ʱ����ָ��ͣ��Ҫɾ���ڵ��ǰһ���ڵ�λ�ã�slow.next=slow.next.next
    * ͬʱ���ǵ�Ϊ�˱���ͷ�ڵ���ж����������ͨ������һ���ƽڵ�
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1.�½�һ���ưͽڵ㣬����ͷ�ڵ���������
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        //2.fast�ڵ�����n��
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        //3.����ָ���nextΪ��ʱֹͣ����ʱ��ָ������len-1-n����Ϊ������n���ڵ��ǰһ���ڵ�
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}