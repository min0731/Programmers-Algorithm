import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 괄호를 맞추기 위한 스택 선언
        Stack <Character> stack = new Stack<>();
 
            for (int i=0; i<s.length(); i++){
                if(s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                }
                else if (s.charAt(i) ==')') {
                    if (stack.size()==0) return false;
                stack.pop();
                }
            }
              if (!stack.isEmpty()) answer= false;
              return answer;
    }
}