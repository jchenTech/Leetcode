class Solution {
    /** 
    * ʹ��ջ�ռ�洢�ַ����е��ַ�����������#��ʱ����ǰһλԪ�س�ջ
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

    //���ַ����е��ַ��ŵ�ջ�ռ��У�������'#'��ջ��Ϊ��ʱջ��Ԫ�س�ջ
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