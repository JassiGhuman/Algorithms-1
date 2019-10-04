class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(stack.size()==0)
                stack.push(c);
            else
            {
                int top = stack.peek();
                if(top == '[' && c == ']'
                   || top == '(' && c == ')'
                   || top == '{' && c == '}')
                {
                    stack.pop();
                }
                else
                {
                    stack.push(c);
                }
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
}
