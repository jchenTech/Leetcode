class MinStack {
    /**本题难点在于实现min()函数，使其在O(1)时间复杂度输出栈的最小元素，因此需要一个辅助栈
    只需设法维护好栈B的元素，使其保持非严格降序，即可实现min()函数的O(1)复杂度。*/

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
        //Java 代码中，由于 Stack 中存储的是 int 的包装类 Integer ，
        //因此需要使用 equals() 代替 == 来比较值是否相等！！！！
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