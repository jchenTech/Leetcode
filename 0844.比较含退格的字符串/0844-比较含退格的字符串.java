class Solution {
    /** 
    * 使用栈空间存储字符串中的字符，当遇到‘#’时，将前一位元素出栈
    */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = buildStack(S);
        Stack<Character> stack2 = buildStack(T);
        
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()){
                return false;
            }
        }
        return true;
    }

    //将字符串中的字符放到栈空间中，当出现'#'且栈不为空时栈顶元素出栈
    private static Stack<Character> buildStack(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stack.push(S.charAt(i));
            }else if (!stack.isEmpty()){
                stack.pop();
            }
        }
        return stack;
    }
}