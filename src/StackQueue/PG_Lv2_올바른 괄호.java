import java.util.*;
//+6점
class Solution {
   boolean solution(String s) {
      boolean answer = true;

      Stack<Character> stack = new Stack<>();
      for(int i =0;i<s.length();i++){
         if(!stack.isEmpty()&&s.substring(i,i+1).charAt(0)==')'&&stack.peek()=='(')
            stack.pop();
         else stack.push(s.substring(i,i+1).charAt(0));
      }
      if(!stack.isEmpty())
         answer=false;
      return answer;
   }
}