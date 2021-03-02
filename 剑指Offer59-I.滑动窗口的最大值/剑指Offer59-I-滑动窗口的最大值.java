class Solution {
    //采用双向单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //未形成窗口前，保证队列呈单调递减，新元素与队列尾部比较，将<新元素的元素移出队列
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        //形成窗口后，
        for (int i = k; i < nums.length; i++) {
            //当队列首位为窗口滑动要删除的元素，则移除首位元素
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            //类似的，保持队列单调递减，从队尾删除比新元素小的元素，将新元素插入队尾
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}