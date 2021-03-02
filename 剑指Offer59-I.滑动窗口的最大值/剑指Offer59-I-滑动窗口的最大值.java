class Solution {
    //����˫�򵥵�����
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //δ�γɴ���ǰ����֤���гʵ����ݼ�����Ԫ�������β���Ƚϣ���<��Ԫ�ص�Ԫ���Ƴ�����
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        //�γɴ��ں�
        for (int i = k; i < nums.length; i++) {
            //��������λΪ���ڻ���Ҫɾ����Ԫ�أ����Ƴ���λԪ��
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            //���Ƶģ����ֶ��е����ݼ����Ӷ�βɾ������Ԫ��С��Ԫ�أ�����Ԫ�ز����β
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}