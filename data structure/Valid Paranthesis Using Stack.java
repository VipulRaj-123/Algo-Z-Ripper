
Leetcode question: 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
  
  
  
  
  
  
Solution : 

class Solution {
    private static final char PAREN_OPEN1 = '{';
    private static final char PAREN_OPEN2 = '[';
    private static final char PAREN_OPEN3 = '(';
    private static final char PAREN_CLOSED1 = '}';
    private static final char PAREN_CLOSED2 = ']';
    private static final char PAREN_CLOSED3 = ')';
    
    public boolean isValid(String s) {
        final int L = s.length();
        Deque<Character> stack = new ArrayDeque<Character>();
        char[] chs = s.toCharArray();
            
        for(final char ch: chs){
            switch(ch){
                case PAREN_OPEN1:
                    stack.push(PAREN_CLOSED1);
                    break;
                case PAREN_OPEN2:
                    stack.push(PAREN_CLOSED2);
                    break;
                case PAREN_OPEN3:
                    stack.push(PAREN_CLOSED3);
                    break;
                default:
                    if(stack.isEmpty())
                        return false;
                    if(stack.pop() != ch)
                        return false;
                    break;
            }
        }
        
        if(!stack.isEmpty()) 
            return false;
        
        return true;
    }
}
