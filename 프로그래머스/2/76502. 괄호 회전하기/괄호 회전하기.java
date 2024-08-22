import java.util.*;

/*
    1. 괄호의 닫힘 먼저 나오면 실패
    2. 스택을 이용해서 올바른 괄호가 되는지 찾음 
    3. 왼쪽으로 x칸 만큼 회전 (총 문자열의 길이만큼 이동함 )
*/

class Solution {
    public int solution(String s) {
        int answer = 0;
        int SIZE = s.length();
        
        //  3. 왼쪽으로 x칸 만큼 회전 
        for (int i = 0; i< SIZE; i++){
            s = (s.substring(1)+s.charAt(0));
            if(check(s)) answer+=1;
        }
        
        return answer;
    }
    
    public boolean check(String s){
        
        Stack<Character> stack = new Stack<>();
        char str[] = s.toCharArray();
        
        
        // 잘못된 시작이면 가차없이 종료맨
        if (str[0] == ')' || str[0] == ']' || str[0] == '}')
            return false;
        
        for (int i= 0; i< str.length; i++){
            if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
                stack.add(str[i]);
            }
            //
            else if (str[i] == ')' && !stack.empty() && stack.peek() == '(') stack.pop();
            else if (str[i] == ']' && !stack.empty() && stack.peek() == '[') stack.pop();
            else if (str[i] == '}' && !stack.empty() && stack.peek() == '{') stack.pop();
        }
        
        if (stack.empty()) return true;
        else return false;
        
        
    }
}