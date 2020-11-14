class MinStack {
    private Stack<Integer> S1, S2;

    /** initialize your data structure here. */
    public MinStack() {
        S1 = new Stack<>();
        S2 = new Stack<>();//¸¨ÖúÕ»
    }
    
    public void push(int x) {
        S1.push(x);
        if (S2.empty() || S2.peek() >= x) {
            S2.push(x);
        }
    }
    
    public void pop() {
        if(S1.peek().equals(S2.peek())) {
            S2.pop();
        }
        S1.pop();
            
    }
    
    public int top() {
        return S1.peek();
    }
    
    public int min() {
        return S2.peek();
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