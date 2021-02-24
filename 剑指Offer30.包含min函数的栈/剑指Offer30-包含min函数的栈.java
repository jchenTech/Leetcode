class MinStack {
    /**�����ѵ�����ʵ��min()������ʹ����O(1)ʱ�临�Ӷ����ջ����СԪ�أ������Ҫһ������ջ
    ֻ���跨ά����ջB��Ԫ�أ�ʹ�䱣�ַ��ϸ��򣬼���ʵ��min()������O(1)���Ӷȡ�*/

    private Stack<Integer> stack1, stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }
    
    public void pop() {
        //Java �����У����� Stack �д洢���� int �İ�װ�� Integer ��
        //�����Ҫʹ�� equals() ���� == ���Ƚ�ֵ�Ƿ���ȣ�������
        if (stack1.peek().equals(stack2.peek())) {
            stack2.pop();
        }
        stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */